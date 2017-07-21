package model;
/*
 * �뵒鍮꾩젒�냽�븯�뒗 鍮꾩��땲�뒪 濡쒖쭅�쓣 �떞怨� �엳�뒗 DAO �겢�옒�뒪 ::
 * MVC �뿉�꽌 M(Model)�뿉 �빐�떦�맂�떎.
 * Model�� �겕寃� �몢 媛�吏�濡� �굹�돏�떎(DAO / VO)
 * ==========================================================
 * DAO ::
 * �꽌踰� �궗�씠�뱶�뿉�꽌 �떒 �븳媛쒕쭔 �깮�꽦�븯怨�
 * 利� �떎瑜� 怨녹뿉�꽌�뒗 �빐�떦 �겢�옒�뒪 ���엯�쑝濡� 媛앹껜瑜� �깮�꽦�븯吏� 紐삵븯寃� 留됱븘�넃�뒗�떎.
 * 鍮꾩��땲�뒪 濡쒖쭅�씠 �븘�슂�븳 �꽌釉붾┸�뱾�씠 �븯�굹 �깮�꽦�맂 DAO�쓽 硫붿냼�뱶瑜� 媛곴컖 �샇異쒗빐�꽌 �궗�슜�븯�룄濡� �븳�떎.
 * -------------> �떛湲��넠
 * 1)�씪�떒 �빐�떦 �겢�옒�뒪�뿉�꽌 �븯�굹留� �깮�꽦 : private static�쑝濡� �깮�꽦
 * 2)�깮�꽦�옄 �븵�뿉 private 遺숈뿬�꽌 �떎瑜� 怨녹뿉�꽌 媛앹껜媛� �깮�꽦�릺�뒗 寃껋쓣 留됱븘�몦�떎.
 * 3)�븯�굹 留뚮뱾�뼱�넃�� 媛앹껜瑜� �떎瑜� �꽌釉붾┸�뱾�씠 媛��졇�떎 �벝�닔 �엳�룄濡� public static Object getInstance()
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
		// JNDI API �궗�슜
		try {
			Context ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/oracleDBS");
			System.out.println("[SUCCESS] Look up  DataSource - constructor");
		} catch (NamingException e) {
			System.out.println("[FAIL] Look up  DataSource - constructor");
		}
	}
	
	public  Connection getConnection() throws SQLException{
		// DataSource�뿉�꽌 Connection 鍮뚮젮�삤湲�
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
		MemberVO vo = new MemberVO();
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
	
	public ArrayList<MemberVO> getAllMember() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberVO> allMembers = new ArrayList<MemberVO>();
		
		try {
			conn = getConnection();

			String sql = "select * from member";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				allMembers.add(new MemberVO(rs.getString("id"), rs.getString("name"),  rs.getString("passwd"),rs.getString("addr")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}

		return allMembers;
	}
	
	public boolean idExist(String id) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean found = false;
		
		try {
			conn = getConnection();

			String sql = "select count(-1) from member where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			rs.next();
			if(rs.getInt(1)>0) found = true;
		} finally {
			closeAll(rs, ps, conn);
		}
		System.out.println("found from idExist() :: " + found);
		return found;
	}
	
	public MemberVO login(String id, String password) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		
		try{
			conn = getConnection();
			
			String sql = "select * from member where id = ? and passwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()){
				vo = new MemberVO(id, 
								  rs.getString("name"), 
								  password, 
								  rs.getString("addr"));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		
		return vo;
	}
	
	public void updateMember(MemberVO vo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = getConnection();
			String sql = "update member set name = ?, addr = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getAddress());
			ps.setString(3, vo.getId());
			
			System.out.println(ps.executeUpdate() + " row updated");
		}finally{
			closeAll(ps, conn);
		}
	}
	
	public static MemberDAO getInstance() {
		return daoInstance;
	}
	
}