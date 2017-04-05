package db.step3.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

import config.DBServerInfo;

public class ResultSetMetaDataTest {
	
	// main 보다 먼저 실행되는 static 초기화 블럭에서 Driver Loading
	static {		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 여기서 모든 작업 진행
	public void showDBInfo(String tableName) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// DB Connection
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr",
												"hr");
		System.out.println("DB Connection success");
		
		String query = "select * from " + tableName;
		ps = conn.prepareStatement(query);
		
		// ResultSetMetaData 생성
		rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		
		// 1. The number of the column
		System.out.println("\nThe number of the columns :: " + rsmd.getColumnCount());
		
		// 2. Print every column names using for loop
		System.out.println("\nAll column names of the table :: ");
		for(int i = 1; i <= rsmd.getColumnCount(); i++){
			System.out.println(rsmd.getColumnName(i));
		}
		
		// 3. Print the values of every column using while
		System.out.println("\nAll values of each column :: ");
		while(rs.next()){
			System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " 
								+ rs.getString(3) + " | " + rs.getString(4));
		}
	}
	
	public static void main(String[] args) throws SQLException {
		ResultSetMetaDataTest rsmd = new ResultSetMetaDataTest();
		rsmd.showDBInfo("member");
	}
}
