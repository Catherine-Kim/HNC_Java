package step3.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBServerInfo;
import step3.mvc.exception.DuplicateIdException;
import step3.mvc.exception.RecordNotFoundException;
import step3.mvc.vo.MemberVO;

public class MemberDAO {
	public MemberDAO(){
		try{
			Class.forName(DBServerInfo.DRIVER_NAME);
			System.out.println("����̹� �ε� ����...");
		}catch(ClassNotFoundException e){
			System.out.println("����̹� �ε� ����....");
		}
	}//������ �ݰ�...
	///////////////////// �������� ����  ////////////////////////////
	public Connection getConn() throws SQLException{
		Connection conn = 
		DriverManager.getConnection(DBServerInfo.URL, "hr", "hr");
		System.out.println("��� ���� ����....");
		return conn;
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException{
		if(rs != null) rs.close();
		closeAll(ps, conn);
	}
	
	////////////////////// �����Ͻ� ���� //////////////////////////////////
	
	private boolean idExists(String id, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select id from member where id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();

		return rs.next();
	}
	
	public void registerMember(MemberVO vo) throws SQLException, DuplicateIdException{ //���ڰ�
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConn();
			if (!idExists(vo.getId(), conn)) { // �Է��Ϸ��� ����� table�� ���ٸ�
				String sql = "insert into member values(?, ?, ?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getId());
				ps.setString(2, vo.getPassword());
				ps.setString(3, vo.getName());
				ps.setString(4, vo.getAddress());
				System.out.println(ps.executeUpdate() + " row inserted.");
			} else {
				throw new DuplicateIdException("�̹� ��ϵ� ȸ���Դϴ� .. registerMember()");
			}
		} finally { // catch ���� ����, �츮�� finally�� ���� try�� �� �Ŷ� catch �Ⱦ�
			closeAll(rs, ps, conn);
		}
	}
	
	public MemberVO selectById(String id) throws SQLException, RecordNotFoundException{ //���ڰ�
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = new MemberVO();
		
		try{
			conn = getConn();
			if(idExists(id, conn)){
				String sql = "select id, name, passwd, addr from member where id = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				if(rs.next()){
					vo.setId(rs.getString("id"));
					vo.setName(rs.getString("name"));
					vo.setPassword(rs.getString("passwd"));
					vo.setAddress(rs.getString("addr"));
				}else{
					throw new RecordNotFoundException();
				}
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return vo;
	}

	public void updateMember(MemberVO vo) throws SQLException, RecordNotFoundException{ //���ڰ�
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = getConn();
			if(idExists(vo.getId(), conn)){
				String sql = "update member set name = ?, passwd = ?, addr = ? "
																	+ "where id = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getPassword());
				ps.setString(3, vo.getAddress());
				ps.setString(4, vo.getId());
				System.out.println(ps.executeUpdate() + " row updated.");
			}else{
				throw new RecordNotFoundException();
			}
			
		}finally{
			closeAll(ps, conn);
		}
	}
	
	
	public ArrayList<MemberVO> getAllMember() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try{
			conn = getConn();
			String sql = "select id, name, addr, passwd from member";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new MemberVO(rs.getString("id"), rs.getString("passwd"), rs.getString("name"), rs.getString("addr")));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
	}

	public void deleteMember(String id) throws SQLException, RecordNotFoundException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = getConn();
			if(idExists(id, conn)){
				String sql = "delete from member where id = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1,  id);
				System.out.println(ps.executeUpdate() + " row deleted");
			}else{
				throw new RecordNotFoundException();
			}
		}finally{
			closeAll(ps, conn);
		}
	}
	
	
	public ArrayList<MemberVO> selectByAddress(String address) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try{
			conn = getConn();
			String sql = "select * from member where address = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, address);
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getString("addr").equals(address))
					list.add(new MemberVO(rs.getString("id"), rs.getString("passwd"), rs.getString("name"), rs.getString("addr")));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public int getCountByAddress(String address) throws SQLException{
		
		return selectByAddress(address).size();
	}
}
/*
 * �ۼ� ���� ::
 * 1. registerMember() :: DuplicateIdException �߻��ϵ���..id�� �ִٸ�
 * 2. deleteMember(), updateMember() :: RecordNotFoundException �߻�..���ٸ�
 * 3. Ư���� id�� ����� �ִ��� ������ �˾ƺ��� ����� �������� �̾ƶ�..
 */












