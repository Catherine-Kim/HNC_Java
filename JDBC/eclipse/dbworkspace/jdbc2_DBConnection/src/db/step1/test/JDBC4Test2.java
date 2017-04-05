package db.step1.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.DBServerInfo;

public class JDBC4Test2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// 1. Driver Loading
		Class.forName(DBServerInfo.DRIVER_NAME);
		System.out.println("[SUCCESS] Driver Loading");
		
		// 2. DB Connection
		Connection conn = DriverManager.getConnection(DBServerInfo.URL, DBServerInfo.USER, 
														DBServerInfo.PASSWORD);
		System.out.println("[SUCCESS] DB Connection");
		
		// 3. Statement Creation
		Statement st = conn.createStatement();
		System.out.println("[SUCCESS] Statement Creation");
		
		// 4. Query
		String insertQuery = "insert into member values('222', 'jjk', 'jjkjjk', "
														+ "'Pasadena, California')";
		//System.out.println(st.executeUpdate(insertQuery) + " row inserted.");
		
		String selectQuery = "select name, address from member";
		ResultSet rs = st.executeQuery(selectQuery);
		while(rs.next()){
			System.out.println(rs.getString(1) + " / " + rs.getString(2));
		}
		
		//6. Close
		rs.close();
		st.close();
		conn.close();
	}
}
