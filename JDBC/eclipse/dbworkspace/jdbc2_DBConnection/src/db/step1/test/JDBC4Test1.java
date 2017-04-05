package db.step1.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.DBServerInfo;

public class JDBC4Test1 {
	Connection conn;
	Statement st;
	
	public JDBC4Test1() throws ClassNotFoundException, SQLException {
		// 1. Drive Loading
		Class.forName(DBServerInfo.DRIVER_NAME);
		System.out.println("[SUCCESS] Driver Loading");
		
		// 2. DB Connection
		conn = DriverManager.getConnection(DBServerInfo.URL, DBServerInfo.USER, DBServerInfo.PASSWORD);
		System.out.println("[SUCCESS] DB Connection");
		
		// 3. Statement Creation
		st = conn.createStatement();
		System.out.println("[SUCCESS] Statement Creation");
		
		// 4. Query
		// 4-1. Insert 4 products into the table
		/*String product1 = "(1, 'Moschino', 55.50)";
		String product2 = "(2, 'Balenciaga', 63.71)";
		String product3 = "(3, 'Givenchy', 70.00)";
		String product4 = "(4, 'Miu Miu', 54.99)";
		String insertQuery = "insert into product values";
		
		System.out.println(st.executeUpdate(insertQuery + product1) + " row inserted");
		System.out.println(st.executeUpdate(insertQuery + product2) + " row inserted");
		System.out.println(st.executeUpdate(insertQuery + product3) + " row inserted");
		System.out.println(st.executeUpdate(insertQuery + product4) + " row inserted");*/
		
		// 4-2. Delete 2nd product of the table
		/*String delete2ndQuery = "delete from product where num = 2";
		System.out.println(st.executeUpdate(delete2ndQuery) + " row deleted");*/
		
		// 4-3. Update the price of the last product of the table
		/*String updateLastQuery = "update product set price = 80.99 where num = 4";
		System.out.println(st.executeUpdate(updateLastQuery) + " row updated");*/
		
		// 4-4. Print all the data of the table
		String selectQuery = "select * from product";
		ResultSet rs = st.executeQuery(selectQuery);
		while (rs.next()) {
			System.out.println("Product :: " + rs.getInt(1) + "  " + rs.getString(2) 
			                     + "  " + rs.getFloat(3));
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new JDBC4Test1();
	}
}
