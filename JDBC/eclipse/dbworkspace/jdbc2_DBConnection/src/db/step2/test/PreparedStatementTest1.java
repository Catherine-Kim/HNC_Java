package db.step2.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import config.DBServerInfo;

public class PreparedStatementTest1 {
	public static void main(String[] args) throws Exception {
		// 1. Driver Loading
		Class.forName(DBServerInfo.DRIVER_NAME);
		System.out.println("[SUCCESS] Driver Loading");
		
		// 2. DB Connection
		Connection conn = DriverManager.getConnection(DBServerInfo.URL, 
											DBServerInfo.USER, DBServerInfo.PASSWORD);
		System.out.println("[SUCCESS] DB Connection");
		
		// 3. PreparedStatement Creation
		String insert = "insert into member values(?, ?, ?, ?)";	// 나중에 여기에 값이 binding될 거임
		PreparedStatement ps = conn.prepareStatement(insert);		// 일단 insert는 진행되고 값이 나중에 꽂아지는 형식
		ps.setString(1, "333"); 	// 괄호 안 첫 번째 인자 : 몇 번째 물음표인지
		ps.setString(2, "pjm");		// 괄호 안 두 번째 인자 : value(java의 String으로 표기하면 됨)
		ps.setString(3, "pjmpjm");
		ps.setString(4, "Columbus, Ohio");
		
		System.out.println(ps.executeUpdate() + "row inserted.");
	}
}
