package model;
/*
 * 디비접속하는 비지니스 로직을 담고 있는 DAO 클래스 ::
 * MVC 에서 M(Model)에 해당된다.
 * Model은 크게 두 가지로 나뉜다(DAO / VO)
 * ==========================================================
 * DAO ::
 * 서버 사이드에서 단 한개만 생성하고
 * 즉 다른 곳에서는 해당 클래스 타입으로 객체를 생성하지 못하게 막아놓는다.
 * 비지니스 로직이 필요한 서블릿들이 하나 생성된 DAO의 메소드를 각각 호출해서 사용하도록 한다.
 * -------------> 싱글톤
 * 1)일단 해당 클래스에서 하나만 생성 : private static으로 생성
 * 2)생성자 앞에 private 붙여서 다른 곳에서 객체가 생성되는 것을 막아둔다.
 * 3)하나 만들어놓은 객체를 다른 서블릿들이 가져다 쓸수 있도록 public static Object getInstance()
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	private static MemberDAO daoInstance = new MemberDAO();
	private DataSource ds;
	
	public MemberDAO(){
		// JNDI API 사용
		try {
			Context ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/oracleDBS");
			System.out.println("[SUCCESS] Look up  DataSource - constructor");
		} catch (NamingException e) {
			System.out.println("[FAIL] Look up  DataSource - constructor");
		}
	}
	
	public  Connection getConnection() throws SQLException{
		// DataSource에서 Connection 빌려오기
		return ds.getConnection();
	}
	public void closeAll(PreparedStatement ps, Connection conn)throws SQLException{
		if(ps!=null) ps.close();
	
		if(conn != null) conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn)
																throws SQLException{
		if(rs != null){
			rs.close();
			closeAll(ps, conn);
		}
	}

	// Business Logic
	public void registerMember(MemberVO vo)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=  getConnection();
			
			String sql = "insert into member values(?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getPassword());
			ps.setString(4, vo.getAddress());
			
			System.out.println(ps.executeUpdate() + " row inserted");
		}finally{
			closeAll(ps, conn);
		}
	}
	
	public MemberVO findByIdMember(String id)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try{
			conn = getConnection();
			
			String sql = "select id, name, passwd, addr from member where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()){
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("passwd"));
				vo.setAddress(rs.getString("addr"));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		
		return vo;
	}
	
	public ArrayList<MemberVO> findByAddress(String address) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberVO> foundPeople = new ArrayList<MemberVO>();

		try {
			conn = getConnection();

			String sql = "select id, name, passwd, addr from member where addr = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, address);

			rs = ps.executeQuery();
			while (rs.next()) {
				foundPeople.add(new MemberVO(rs.getString("id"), rs.getString("name"), rs.getString("passwd"), rs.getString("addr")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}

		return foundPeople;
	}
	
	public static MemberDAO getInstance() {
		return daoInstance;
	}
	
}