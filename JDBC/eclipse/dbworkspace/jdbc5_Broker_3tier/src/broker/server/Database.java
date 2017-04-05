package broker.server;
/*
 * Exception ::
 * DuplicateSSNException,
 * RecordNotFoundException,
 * InvalidTransactionException
 * : �ȷ��� �ֽ��� ���ڰ� ������ �ִ°� ���� �� ������
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import broker.exception.DuplicateSSNException;
import broker.exception.InvalidTransactionException;
import broker.exception.RecordNotFoundException;
import broker.vo.CustomerRec;
import broker.vo.SharesRec;
import broker.vo.StockRec;
import config.DBServerInfo;

/*
 * DB�� Access�ϴ� �����Ͻ� ������ ��� �ִ� Ŭ����
 * UseCase Diagram�� ���� ����� ����θ� �̾Ƴ��ڴ�.
 */
public class Database {
	 public Database(String server)throws ClassNotFoundException{
		 Class.forName(DBServerInfo.DRIVER_NAME);
		 System.out.println("����̹� �ε� ����...");
	 }
	 
	 //////// �������� ���� /////////////////////
	 public Connection getConnect() throws SQLException{
		Connection conn = 
				DriverManager.getConnection(DBServerInfo.URL, DBServerInfo.USER, DBServerInfo.PASS);
		System.out.println("��� ���� ����...getConnect()...");
		 return conn;
	 }
	 
	 public void closeAll(PreparedStatement ps, Connection conn)throws SQLException{
		 if(ps != null) ps.close();
		 if(conn != null) conn.close();
	 }
	 public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn)throws SQLException{
		 if(rs != null) rs.close();
			closeAll(ps, conn);
	 }
	 
	 //////////////// �����Ͻ� ���� ////////////////////////////////////
	 private boolean isExist(Connection conn,String ssn) throws SQLException{
		//Connection conn = getConnect();
		String query = "SELECT ssn FROM customer WHERE ssn=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, ssn);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	 }
	 
	 public void addCustomer(CustomerRec cust)throws SQLException, DuplicateSSNException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = getConnect();
			if(!isExist(conn, cust.getSsn())){
				String sql = "insert into customer values(?, ?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				System.out.println(ps.executeUpdate() + " row inserted into customer table.");
			}else{
				throw new DuplicateSSNException(cust.getName() + " ���� �̹� ���Ե� ���Դϴ�.");
			}
		}finally{
			closeAll(ps, conn);
		}		 
	 }
	 
	 public void deleteCustomer(String ssn)throws SQLException,RecordNotFoundException{
		 Connection conn = null;
		 PreparedStatement ps = null;		 
		 try{
			 conn = getConnect();
			 if(isExist(conn, ssn)){
				 String sql = "delete from customer where ssn = ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, ssn);
				 System.out.println(ps.executeUpdate() + " row deleted from customer table.");
			 }else{
				 throw new RecordNotFoundException();
			 }
		 }finally{
			 closeAll(ps, conn);			 
		 }
	 }
	 
	 public void updateCustomer(CustomerRec cust)throws SQLException, RecordNotFoundException{
		 Connection conn = null;
		 PreparedStatement ps = null;		
		 try{
			 conn = getConnect();
			 if(isExist(conn, cust.getSsn())){
				 String sql = "update customer set cust_name = ?, address = ? where ssn = ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, cust.getName());
				 ps.setString(2, cust.getAddress());
				 ps.setString(3, cust.getSsn());
				 System.out.println(ps.executeUpdate() + " row updated in customer table.");
			 }else{
				 throw new RecordNotFoundException();
			 }
		 }finally{
			 closeAll(ps, conn);
		 }
	 }
	 /*
	  * ���� ������ �ֽ� ����(shares)....
	  * �Ѹ��� ���� �������� �ֽ������� �����Ҽ� �ֱ� ������...Vector�� ��Ҵ�.
	  */
	 public Vector<SharesRec> getPortfolio(String ssn)throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 Vector<SharesRec> v = new Vector<SharesRec>();
		 try{
			 conn = getConnect();
			 String sql = "select ssn, symbol, quantity from shares where ssn = ?";
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, ssn);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 v.add(new SharesRec(rs.getString("ssn"), rs.getString("symbol"), rs.getInt("quantity")));
			 }
		 }finally{
			 closeAll(rs, ps, conn);
		 }
		 return v; //while�� �ٱ�����...
	 }
	 /*
	  * ���� ���� ���� ����(customer) + ���� ������ �ֽ� ����(shares)....
	  */
	 public CustomerRec getCustomer(String ssn)throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 CustomerRec cust = null;
		 try{
			conn = getConnect();
			String sql = "select * from customer where ssn = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			if(rs.next()){
				cust = new CustomerRec(ssn, rs.getString("cust_name"), rs.getString("address"));
			}
			cust.setPortfolio(getPortfolio(ssn));
		 }finally{
			 closeAll(rs, ps, conn);
		 }
		 return cust;
	 }
	 public ArrayList<CustomerRec> getAllCustomers()throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 ArrayList<CustomerRec> list = new ArrayList<CustomerRec>();
		 try{
			 conn = getConnect();
			 String sql = "select * from customer";
			 ps = conn.prepareStatement(sql);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 list.add(new CustomerRec(rs.getString("ssn"), rs.getString("cust_name"), rs.getString("address"), getPortfolio(rs.getString("ssn"))));
			 }
		 }finally{
			 closeAll(rs, ps, conn);
		 }
		 return list;
	 }
	 
	 public ArrayList<StockRec> getAllStocks()throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 ArrayList<StockRec> list = new ArrayList<StockRec>();
		 try{
			conn = getConnect();
			String sql ="select * from stock";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new StockRec(rs.getString("symbol"), rs.getFloat("price")));
			}
		 }finally{
			 closeAll(rs, ps, conn);
		 }
		 return list;
	 }
	 
	 public float getStcokPrice(String symbol)throws SQLException,RecordNotFoundException{
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 float price = 0.0f;
		 
		 try{
			
		 }finally{
			 closeAll(rs, ps, conn);
		 }
		 return price;
	 }
	 
	
	 //���� � �ֽ��� � ��ų�...
	 //������ �ֳľ��ĸ� ���� �˾ƺ���.
	 //������...update / ������...insert
	 public void buyShares(String ssn, String symbol, int quantity)
	 				throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 try{
			conn = getConnect();
			String sql = "select quantity from shares where ssn = ? and symbol = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ssn);
			ps.setString(2, symbol);
			rs = ps.executeQuery();
			if(rs.next()){
				String sql2 = "update shares set quantity = ? where ssn = ? and "
						+ "symbol = ?";
				int q = rs.getInt(1);
				int newQ = q + quantity;
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, newQ);
				ps.setString(2, ssn);
				ps.setString(3, symbol);
				System.out.println(ps.executeUpdate() + " row updated - buyShares()");
			}else{
				String sql2 = "insert into shares values(?, ?, ?)";
				ps = conn.prepareStatement(sql2);
				ps.setString(1, ssn);
				ps.setString(2, symbol);
				ps.setInt(3, quantity);
				System.out.println(ps.executeUpdate() + "row inserted - buyShares()");
			}
		 }finally{
			 closeAll(rs, ps, conn);
		 }
	 }
	//���� � �ֽ��� � �Ȱų�...��� ���� ������ �ִ���...quantity
	 /*
	  * 100�� ������ �ִ�(���� �����ϰ� �ִ� �ֽ��� ����)
	  * 1) 100�� �ȾҴٸ�-----delete
	  * 2) 200�� �ȾҴٸ�----InvalidTransactionE~~
	  * 3) 20�� �ȾҴٸ� ---- update
	  */
	 public void sellShares(String ssn, String symbol, int quantity)
			 throws SQLException,RecordNotFoundException,InvalidTransactionException{
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 try{
			conn = getConnect();
			String sql = "select quantity from shares where ssn = ? and symbol = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ssn);
			ps.setString(2, symbol);
			rs = ps.executeQuery();
			if(rs.next()){
				int q = rs.getInt(1);
				if(q > quantity){
					String sql2 = "update shares set quantity = ? where ssn = ? and "
							+ "symbol = ?";
					ps = conn.prepareStatement(sql2);
					ps.setInt(1, q - quantity);
					ps.setString(2, ssn);
					ps.setString(3, symbol);
					System.out.println(ps.executeUpdate() + " row updated - "
							+ "sellShares()");
				}else if(q == quantity){	// delete
					String sql2 = "delete from shares where ssn = ? and symbol = ?";
					ps = conn.prepareStatement(sql2);
					ps.setString(1, ssn);
					ps.setString(2, symbol);
					System.out.println(ps.executeUpdate() + " row deleted- "
							+ "sellShares()");
				}else{
					throw new InvalidTransactionException("�ȷ��� �ֽ��� �ʹ� ����");
				}
			}else{
				throw new RecordNotFoundException("�Ȱ��� �ϴ� �ֽ��� ����");
			}
		 }finally{
			 closeAll(ps, conn);			 
		 }
	 }
	 
	 public void updateStockPrice(String symbol, float price) throws SQLException{
		 Connection conn=  null;
		 PreparedStatement ps = null;
		 try{
			 
		 }finally{
			 closeAll(ps, conn);
		 }
		 
	 }
	 
	 /*public static void main(String[] args) throws SQLException, DuplicateSSNException, ClassNotFoundException, RecordNotFoundException{
		 Database db = new Database("127.0.0.1");
		 //db.addCustomer(new CustomerRec("777-777", "�����", "������"));
		 //db.deleteCustomer("777-777");
		 //db.updateCustomer(new CustomerRec("777-777", "�����", "���ϵ�"));
		 Vector<SharesRec> list = db.getPortfolio("777-777");
		 for(SharesRec s : list){
			 System.out.println(s);
		 }
	 }*/
}//class


















