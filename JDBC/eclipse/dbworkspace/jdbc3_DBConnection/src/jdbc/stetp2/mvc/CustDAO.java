package jdbc.stetp2.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBServerInfo;

public class CustDAO {
	// 각 메소드의 공통적인 부분 - 이 부분은 다른 클래스에서 호출할 일 없으므로 private으로 지정
	private Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(DBServerInfo.URL, 
											DBServerInfo.USER, DBServerInfo.PASSWORD);
		System.out.println("[SUCCESS] DB Connection");
		 return conn;
	}

	private void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	private void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) 
																throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	// Business Logic
	public void addCust(CustVO vo) throws SQLException {
		// local variables
		Connection conn = null;
		PreparedStatement ps = null;
		
		// DB Connection
		conn = getConnection();
		
		// Query & PreparedStatement
		ps = conn.prepareStatement("insert into cust values(?, ?, ?)");
		
		// Data Binding
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getName());
		ps.setString(3, vo.getAddr());
		
		// Query Execution
		System.out.println(ps.executeUpdate() + " row inserted.");
		
		// Closing
		closeAll(ps, conn);
	}

	public void deleteCust(String id) throws SQLException {
		// local variables
		Connection conn = null;
		PreparedStatement ps = null;

		// DB Connection
		conn = getConnection();

		// Query & PreparedStatement
		ps = conn.prepareStatement("delete from cust where id = ?");
		
		// Data Binding
		ps.setString(1, id);
		
		// Query Execution
		System.out.println(ps.executeUpdate() + " row deleted.");
		
		// Closing
		closeAll(ps, conn);
	}

	public void updateCust(CustVO vo) throws SQLException {
		// local variables
		Connection conn = null;
		PreparedStatement ps = null;

		// DB Connection
		conn = getConnection();

		// Query & PreparedStatement
		ps = conn.prepareStatement("update cust set name = ?, addr = ? where id = ?");
		
		// Data Binding
		ps.setString(1, vo.getName());
		ps.setString(2, vo.getAddr());
		ps.setString(3, vo.getId());
		
		// Query Execution
		System.out.println(ps.executeUpdate() + " row updated.");
		
		// Closing
		closeAll(ps, conn);
	}

	public ArrayList<CustVO> getAllCusts() throws SQLException {
		// local variables
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CustVO> foundPPL = new ArrayList<CustVO>();

		// DB Connection
		conn = getConnection();

		// Query & PreparedStatement(No Data Binding)
		ps = conn.prepareStatement("select id, name, addr from cust");
		
		// Query Execution
		rs = ps.executeQuery();
		
		// ResultSet into arraylist
		while(rs.next()){
			foundPPL.add(new CustVO(rs.getString("id"), rs.getString("name"), 
															rs.getString("addr")));
		}
		
		// Closing
		closeAll(rs, ps, conn);
		
		return foundPPL;
	}

	public CustVO getACust(String id) throws SQLException {
		// local variables
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustVO found = new CustVO();
				
		// DB Connection
		conn = getConnection();

		// Query & PreparedStatement
		ps = conn.prepareStatement("select id, name, addr from cust where id = ?");

		// Data Binding
		ps.setString(1, id);
		
		// Query Execution
		rs = ps.executeQuery();

		// ResultSet into CustVO
		if (rs.next()) {
			found.setId((rs.getString("id")));
			found.setName((rs.getString("name")));
			found.setAddr((rs.getString("addr")));
		}		
		
		closeAll(rs, ps, conn);

		return found;
	}

	public ArrayList<CustVO> findCustByAddr(String addr) throws SQLException {
		// local variables
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CustVO> foundPPL = new ArrayList<CustVO>();

		// DB Connection
		conn = getConnection();

		// Query & PreparedStatement(No Data Binding)
		ps = conn.prepareStatement("select id, name, addr from cust where addr = ?");
		
		// Data Binding
		ps.setString(1, addr);
		
		// Query Execution
		rs = ps.executeQuery();
		
		// ResultSet into ArrayList
		while(rs.next()){
			foundPPL.add(new CustVO(rs.getString("id"), rs.getString("name"), 
															rs.getString("addr")));
		}
		
		// Closing
		closeAll(rs, ps, conn);
		
		return foundPPL;
	}
}
