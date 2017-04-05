package db.step1.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//JDBC 4단계
public class DBConnectionTest3 {
	Connection conn;
	Statement st;
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String driverName = "oracle.jdbc.driver.OracleDriver";
	
	public DBConnectionTest3() throws Exception{
		// 1. Driver Loading
		Class.forName(driverName);
		System.out.println("[SUCCESS] Driver Loading");
		
		// 2. DB Connection
		conn = DriverManager.getConnection(url, "hr", "hr");
		System.out.println("[SUCCESS] DB Connection");
		
		// 3. Statement Creation
		st = conn.createStatement();
		System.out.println("[SUCCESS] Statement Creation");
		
		// 4. Select data
		String selectQuery = "select * from member";
		ResultSet rs = st.executeQuery(selectQuery);
		
		while(rs.next()){
			System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  "
								+ rs.getString(3));
		}
		
	}
	public static void main(String[] args) throws Exception{
		new DBConnectionTest3();		
	}
}


///////////////////////////////////////////////
// ResultSet은 처음을 가리키는 index가 0이 아니라 1
/*System.out.println(rs.getString("id"));
System.out.println(rs.getString("name"));
System.out.println(rs.getInt("age"));*/