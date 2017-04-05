package jdbc.step1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.step1.config.DBInfo;
import jdbc.step1.vo.KostaVO;

public class KostaDAO {
	// DB Connection
	public Connection getConnection() throws SQLException{
		Connection conn = null;
		conn = DriverManager.getConnection(DBInfo.url, DBInfo.user, DBInfo.pw);
		System.out.println("[SUCCESS] DB Connection");
		return conn;
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		ps.close();
		conn.close();
	}
	
	public void addKosta(KostaVO vo) throws SQLException{
		// local variables
		Connection conn = null;
		PreparedStatement ps = null;
		
		// 2. DB Connection
		conn = getConnection();
		
		// 3. PreparedStatement
		String sql = "insert into kosta values(?, ?, ?)";
		ps = conn.prepareStatement(sql);
		
		// 4. Data Binding
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getName());
		ps.setString(3, vo.getAddress());
		
		// 5. Query Execution
		System.out.println(ps.executeUpdate() + " row inserted");
		
		// 6. Closing
		closeAll(ps, conn);
	}
	
	public void printAllKosta() throws SQLException{
		// local variables
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 2. DB Connection
		conn = getConnection();
		
		// 3. PreparedStatement
		String sql = "select * from kosta";
		ps = conn.prepareStatement(sql);
		
		// 4. Data Binding - Nothing to bind
		
		// 5. Query Execution
		rs = ps.executeQuery();
		while(rs.next()){
			
		}
		
		// 6. Closing
	}
}
