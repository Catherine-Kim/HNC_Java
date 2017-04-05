package db.step1.test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest2 {
	Connection conn;
	Statement st;
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	
	public DBConnectionTest2() throws ClassNotFoundException, SQLException{
		// 1. Driver Loading
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1. Driver Loading success");
		
		// 2. DB server connection
		conn = DriverManager.getConnection(url, "hr", "hr");
		System.out.println("2. DB Server Connection success");
		
		// 3. Statement 생성
		st = conn.createStatement();
		System.out.println("3. Statement Creating success");
		
		// 4. SQL 구문 실행(executeQuery() | executeUpdate())
		// member table에 'Irene' 추가
		String sql1 = "insert into member values('f(x)_1', 'Victoria', 27)";
		st.executeUpdate(sql1);
		System.out.println("Insertion has been made.");
		
		// 5. member table에서 'Irene' 삭제
		/*String sql2 = "delete from member where id='redvelvet_1'";
		st.executeUpdate(sql2);
		System.out.println("Deletion has been made.");*/
		
		// 6. Victoria의 나이를 27으로 바꿔보자
		/*String sql3 = "update member set age=27 where id ='f(x)_1'";
		st.executeUpdate(sql3);
		System.out.println("Update has been made.");*/
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		new DBConnectionTest2();
	}
}
