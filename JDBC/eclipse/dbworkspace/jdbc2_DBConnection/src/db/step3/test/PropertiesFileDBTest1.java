package db.step3.test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class PropertiesFileDBTest1 {
	public static void main(String[] args) throws Exception {
		// Properties class creation and properties file loading
		Properties p = new Properties();
		p.load(new FileInputStream("src/config/db.properties"));
		
		// Get properties of the Properties
		String driver = p.getProperty("jdbc.oracle.driver");
		String url = p.getProperty("jdbc.oracle.url");
		String user = p.getProperty("jdbc.oracle.user");
		String pw = p.getProperty("jdbc.oracle.pw");
		
		// 1. Driver Loading
		Class.forName(driver);
		System.out.println("[SUCCESS] Driver Loading");
		
		// 2. DB Connection
		Connection conn = DriverManager.getConnection(url, user, pw);
		System.out.println("[SUCCESS] DB Connection");
		
		// 3. PreparedStatement Creation
		// 3-1. Insert two members into the table
		/*PreparedStatement ps = conn.prepareStatement(p.getProperty("jdbc.sql.insert"));
		ps.setString(1, "444");
		ps.setString(2, "kth");
		ps.setString(3, "kthkth");
		ps.setString(4, "Salem, Oregon");
		System.out.println(ps.executeUpdate() + " row inserted.");
		
		PreparedStatement ps2 = conn.prepareStatement(p.getProperty("jdbc.sql.insert"));
		ps2.setString(1, "555");
		ps2.setString(2, "myg");
		ps2.setString(3, "mygmyg");
		ps2.setString(4, "Boston, Massachusetts");
		System.out.println(ps2.executeUpdate() + " row inserted.");
		
		// 3-2. Update the address of the last member
		PreparedStatement ps3 = conn.prepareStatement(p.getProperty("jdbc.sql.update.addr"));
		ps3.setString(1, "LA, California");
		ps3.setString(2, "555");
		System.out.println(ps3.executeUpdate() + " row updated");
		
		// 3-3. Delete the member whose id is 444
		PreparedStatement ps4 = conn.prepareStatement(p.getProperty("jdbc.sql.delete.id"));
		ps4.setString(1, "444");
		System.out.println(ps4.executeUpdate() + " row deleted");
		
		// 3-4. Print all the members of the table
		PreparedStatement ps5 = conn.prepareStatement(p.getProperty("jdbc.sql.select"));
		ResultSet rs = ps5.executeQuery();
		System.out.println("All the members of the table ::");
		while(rs.next()){
			System.out.println(rs.getString("id") + " | " + rs.getString("name") + " | " 
														+ rs.getString("addr"));
		}*/
		
		// 3-5. Print members who live in LA, California
		PreparedStatement ps6 = conn.prepareStatement(p.getProperty("jdbc.sql.select.address"));
		ps6.setString(1, "LA, California");
		ResultSet rs2 = ps6.executeQuery();
		System.out.println("Members who live in LA, California ::");
		while(rs2.next()){
			System.out.println(rs2.getString("id") + " | " + rs2.getString("name") + " | " 
															+ rs2.getString("addr"));
		}
	}
}
