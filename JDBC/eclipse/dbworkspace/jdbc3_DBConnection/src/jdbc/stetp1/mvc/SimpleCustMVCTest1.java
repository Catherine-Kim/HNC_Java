package jdbc.stetp1.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBServerInfo;

public class SimpleCustMVCTest1 {
	public SimpleCustMVCTest1() throws Exception {
		Class.forName(DBServerInfo.DRIVER_NAME);
		System.out.println("Driver Loading Success");
	}

	// 5�ܰ� �� �������� �κ� 1) DB Connection
	public Connection getConnection() throws SQLException {
		// 1. DB Connection
		Connection conn = DriverManager.getConnection(DBServerInfo.URL, 
											DBServerInfo.USER, DBServerInfo.PASSWORD);
		System.out.println("DB Connection Success");
		return conn;
	}

	// 5�ܰ� �� �������� �κ� 2) Closing
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null) ps.close();
		if (conn != null) conn.close();
	}

	// 5�ܰ� �� �������� �κ� 2) Closing <Overloding>
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) 
																throws SQLException {
		if (rs != null) rs.close();
		closeAll(ps, conn);		// if������ ������ ���� ����, �޼ҵ带 �����ϰ� ����
	}

	// Business Logic
	// ������ ���ڷ� VO�� ���� ������ ������ ������ ������ �־��ٰ���
	public void insertCust(String name, int age, int height, int weight, String gender) 
																throws SQLException {
		// local variables
		Connection conn = null;
		PreparedStatement ps = null;

		// 1. DB Connection
		conn = getConnection();

		// 2. PreparedStatement
		ps = conn.prepareStatement("insert into customer " + "values(?, ?, ?, ?, ?)");
		
		// 3. Data Binding
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setInt(3, height);
		ps.setInt(4, weight);
		ps.setString(5, gender);

		// 4. Query Executing
		System.out.println(ps.executeUpdate() + " row inserted.");

		// 5. Close
		closeAll(ps, conn);
	}
	
	public void deleteCust(String name) throws SQLException{
		// local variables
		Connection conn = null;
		PreparedStatement ps = null;
		
		// 1. DB Connection
		conn = getConnection();
		
		// 2. PreparedStatement
		ps = conn.prepareStatement("delete from customer where name = ?");
		
		// 3. Data Binding
		ps.setString(1, name);
		
		// 4. Query Executing
		System.out.println(ps.executeUpdate() + " row deleted");
		
		// 5. Close
		closeAll(ps, conn);
	}
	
	public void updateCust(String name, int age, int height, int weight, String gender)
																throws SQLException{
		// local variables
		Connection conn = null;
		PreparedStatement ps = null;
		
		// 1. DB Connection
		conn = getConnection();

		// 2. PreparedStatement
		ps = conn.prepareStatement("update customer set name = ?, age = ?, "
								+ "height = ?, weight = ?, gender = ? where name = ?");
		
		// 3. Data Binding
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setInt(3, height);
		ps.setInt(4, weight);
		ps.setString(5, gender);
		ps.setString(6, name);
		
		// 4. Query Executing
		System.out.println(ps.executeUpdate() + " row updated");
		
		// 5. Close
		closeAll(ps, conn);
	}

	public void printAllCusts() throws SQLException{
		// local variables
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 1. DB Connection
		conn = getConnection();
		
		// 2. PreparedStatement
		ps = conn.prepareStatement("select * from customer");
		
		// No data binding
		// 3. Query Executing
		rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("name") + " | " +rs.getInt("age") + 
							" | " +rs.getInt("height") + " | " +rs.getInt("weight") + 
							" | " + rs.getString("gender"));
		}

		// 4. Close
		closeAll(rs, ps, conn);
	}

	public void printACust(String name) throws SQLException {
		// local variables
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 1. DB Connection
		conn = getConnection();

		// 2. PreparedStatement
		ps = conn.prepareStatement("select name, age, height, weight, gender from "
														+ "customer where name = ?");

		// 3. Data Binding
		ps.setString(1, name);		
		
		// 4. Query Executing
		rs = ps.executeQuery();
		
		while(rs.next()){
			if(rs.getString("name").equals(name)){
				System.out.println(rs.getString("name") + " | " +rs.getInt("age") + 
							" | " + rs.getInt("height") + " | " +rs.getInt("weight") + 
							" | " + rs.getString("gender"));
				break;
			}
		}

		// 5. Close
		closeAll(rs, ps, conn);
	}

	public static void main(String[] args) throws Exception {
		SimpleCustMVCTest1 test1 = new SimpleCustMVCTest1();

		// ������ UI���� ���� �Է¹޾ƾ� ������, �Է¹޾Ҵ� ġ�� �̹��� ���� �־��
		//test1.insertCust("Woojeong Kim", 24, 155, 50, "F");
		//test1.deleteCust("Vanessa Hudgens");
		//test1.updateCust("Chris Pratt", 22, 190, 66, "M");
		//test1.printAllCusts();
		test1.printACust("Woojeong Kim");
	}
}
