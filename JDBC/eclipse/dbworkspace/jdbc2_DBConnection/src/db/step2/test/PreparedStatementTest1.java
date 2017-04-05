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
		String insert = "insert into member values(?, ?, ?, ?)";	// ���߿� ���⿡ ���� binding�� ����
		PreparedStatement ps = conn.prepareStatement(insert);		// �ϴ� insert�� ����ǰ� ���� ���߿� �Ⱦ����� ����
		ps.setString(1, "333"); 	// ��ȣ �� ù ��° ���� : �� ��° ����ǥ����
		ps.setString(2, "pjm");		// ��ȣ �� �� ��° ���� : value(java�� String���� ǥ���ϸ� ��)
		ps.setString(3, "pjmpjm");
		ps.setString(4, "Columbus, Ohio");
		
		System.out.println(ps.executeUpdate() + "row inserted.");
	}
}
