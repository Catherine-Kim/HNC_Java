package db.step2.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.DBServerInfo;

public class PreparedStatementTest2 {
	public static void main(String[] args) throws Exception {
		// 1. Driver Loading
		Class.forName(DBServerInfo.DRIVER_NAME);
		System.out.println("[SUCCESS] Driver Loading");
		
		// 2. DB Connection
		Connection conn = DriverManager.getConnection(DBServerInfo.URL, 
											DBServerInfo.USER, DBServerInfo.PASSWORD);
		System.out.println("[SUCCESS] DB Connection");
		
		// 3. PreparedStatment Creation and Query
		// 3-1. Delete 2nd member of the table
		/*String deleteQuery = "delete from member where id = ?";
		PreparedStatement ps = conn.prepareStatement(deleteQuery);
		ps.setString(1, "222");
		System.out.println(ps.executeUpdate() + " row deleted.");*/
		
		// 3-2. Update the address and the name of the 1st member of the table
		/*String updateQuery = "update member set name = ?, addr = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(updateQuery);
		ps.setString(1, "Friendship");
		ps.setString(2, "Austin, Texas");
		ps.setString(3, "111");
		System.out.println(ps.executeUpdate() + " row updated.");*/
		
		// 3-3. Print all the members' id, name, and address
		String selectQuery = "select id, name, addr from member";
		PreparedStatement ps = conn.prepareStatement(selectQuery);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			System.out.println("ID : " + rs.getString(1) 
								+ " || NAME : " + rs.getString(2) 
								+ " || ADDRESS : " + rs.getString(3));
		}
	}
}
