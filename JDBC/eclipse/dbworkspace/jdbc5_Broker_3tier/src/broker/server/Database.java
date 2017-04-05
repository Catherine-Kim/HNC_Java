package broker.server;
/*
 * Exception ::
 * DuplicateSSNException,
 * RecordNotFoundException,
 * InvalidTransactionException
 * : 팔려는 주식의 숫자가 가지고 있는것 보다 더 많을떄
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
 * DB에 Access하는 비지니스 로직을 담고 있는 클래스
 * UseCase Diagram을 보고서 기능의 선언부를 뽑아내겠다.
 */
public class Database {
	 public Database(String server)throws ClassNotFoundException{
		 Class.forName(DBServerInfo.DRIVER_NAME);
		 System.out.println("드라이버 로딩 성공...");
	 }
	 
	 //////// 공통적인 로직 /////////////////////
	 public Connection getConnect() throws SQLException{
		Connection conn = 
				DriverManager.getConnection(DBServerInfo.URL, DBServerInfo.USER, DBServerInfo.PASS);
		System.out.println("디비 연결 성공...getConnect()...");
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
	 
	 //////////////// 비지니스 로직 ////////////////////////////////////
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
				throw new DuplicateSSNException(cust.getName() + " 님은 이미 가입된 고객입니다.");
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
	  * 고객이 보유한 주식 정보(shares)....
	  * 한명의 고객이 여러개의 주식종복을 보유할수 있기 때문에...Vector에 담았다.
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
		 return v; //while문 바깥에서...
	 }
	 /*
	  * 순수 고객에 대한 정보(customer) + 고객이 보유한 주식 정보(shares)....
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
	 
	
	 //누가 어떤 주식을 몇개 살거냐...
	 //가지고 있냐없냐를 먼저 알아본다.
	 //있으면...update / 없으면...insert
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
	//누가 어떤 주식을 몇개 팔거냐...몇개를 현재 가지고 있는지...quantity
	 /*
	  * 100개 가지고 있다(현재 보유하고 있는 주식의 수량)
	  * 1) 100개 팔았다면-----delete
	  * 2) 200개 팔았다면----InvalidTransactionE~~
	  * 3) 20개 팔았다면 ---- update
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
					throw new InvalidTransactionException("팔려는 주식이 너무 많음");
				}
			}else{
				throw new RecordNotFoundException("팔고자 하는 주식이 없음");
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
		 //db.addCustomer(new CustomerRec("777-777", "김우정", "죽전동"));
		 //db.deleteCustomer("777-777");
		 //db.updateCustomer(new CustomerRec("777-777", "김우정", "경상북도"));
		 Vector<SharesRec> list = db.getPortfolio("777-777");
		 for(SharesRec s : list){
			 System.out.println(s);
		 }
	 }*/
}//class


















