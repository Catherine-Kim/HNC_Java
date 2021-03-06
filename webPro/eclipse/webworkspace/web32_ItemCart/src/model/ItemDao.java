package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ItemDao {
	private DataSource ds;
	private static ItemDao dao = new ItemDao();
	private ItemDao(){
		//DataSource를 받아와야 한다...NamingService(JNDI)
		System.out.println("DataSource Lookup....");
		try{
			Context ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDBS");
			System.out.println("return....DataSource...");
		}catch(NamingException e){
			System.out.println("fail....DataSource...");
		}
		
	}
	public static ItemDao getInstance(){
		return dao;
	}
	
	public  Connection getConnection() throws SQLException{
		System.out.println("디비연결 성공....");
		return ds.getConnection();
	}
	public void closeAll(PreparedStatement ps, Connection conn)throws SQLException{
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn)throws SQLException{
		if(rs!=null){
			rs.close();
			closeAll(ps, conn);
		}
	}//
	///////////////////////// 비지로직 ///////////////////////////////
	public ArrayList<Item> getAllItems() throws SQLException{
		ArrayList<Item> list = new ArrayList<Item>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=  null;
		
		try{
			conn=getConnection();
			
			String sql = "select * from item";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new Item(rs.getInt(1), 
									rs.getString(2),
									rs.getInt(3), 
									rs.getString(4), 
									rs.getString(5), 
									rs.getInt(6)));
			}
			
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;		
	}
	
	public Item getItem(int itemnumber) throws SQLException{
		Item item = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=  null;
		
		try{
			conn = getConnection();
			
			String sql = "select * from item where item_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, itemnumber);
			
			rs = ps.executeQuery();
			if(rs.next())
				item = new Item(itemnumber, rs.getString("item_name"), 
						rs.getInt("price"), rs.getString("description"), 
						rs.getString("picture_url"), rs.getInt("count"));
		}finally{
			closeAll(rs, ps, conn);
		}
		
		return item;
	}
	
	public boolean updateRecordCount(int itemnumber) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		boolean done = false;
		
		try{
			conn = getConnection();
			
			String sql = "update item set count = count+1 where item_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, itemnumber);
			done = true;
			if(ps.executeUpdate() > 0){
				done = true;
			}
		}finally{
			closeAll(ps, conn);
		}
		
		return done;
	}
}





