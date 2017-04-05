package db.step1.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest1 {
	public DBConnectionTest1(){
		// JDBC ���� ����
		// 1. Driver�� �޸𸮿� ����(FQCN �ۼ�)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. Driver Loading...");
		} catch (ClassNotFoundException e) {
			System.out.println("[FAIL] Driver Loading");
		}
		
		// 2. DB ������ �����ؼ� Connection�� ���Ϲ���
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		try {
			Connection conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("2. DB Connection success...");
		} catch (SQLException e) {
			System.out.println("[FAIL] DB Connection");
		}
	}
	public static void main(String[] args) {
		new DBConnectionTest1();
	}
}
