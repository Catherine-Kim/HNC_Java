package model;

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
	private static MemberDAO dao=new MemberDAO();
	private DataSource ds;
	private MemberDAO(){
		ds=DataSourceManager.getInstance().getDataSource();
	}
	public static MemberDAO getInstance(){
		return dao;
	}
	private Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		closeAll(pstmt, con);
	}
	public ArrayList<String> getIdList() throws SQLException{
		ArrayList<String> list = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			String sql = "SELECT id FROM member";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(rs.getString(1));
			}
		}finally{
			closeAll(rs,ps,conn);
		}
		return list;
	}
 	public void updateMember(MemberVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection();
			String sql="update member set password=?,name=?,address=? where id=?";
			pstmt=con.prepareStatement(sql);			
			pstmt.setString(1,vo.getPassword());
			pstmt.setString(2,vo.getName());
			pstmt.setString(3,vo.getAddress());
			pstmt.setString(4,vo.getId());
			int result=pstmt.executeUpdate();
			System.out.println("update ok.."+result);
		}finally{
			closeAll(pstmt,con);
		}
	}
	public void registerMember(MemberVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection();
			String sql="insert into member values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getPassword());
			pstmt.setString(3,vo.getName());
			pstmt.setString(4,vo.getAddress());
			int result=pstmt.executeUpdate();
			System.out.println("insert ok.."+result);
		}finally{
			closeAll(pstmt,con);
		}
	}
	public MemberVO findMemberById(String id) throws SQLException{
		MemberVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql="select passwd,name,addr from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				vo=new MemberVO(id,rs.getString(1),rs.getString(2),rs.getString(3));
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return vo;
	}
	public ArrayList<MemberVO> findByAddress(String address) throws SQLException{
		ArrayList<MemberVO> list=new ArrayList<MemberVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql="select id,name from member where address=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,address);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new MemberVO(rs.getString(1),null,
						rs.getString(2),address));
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return list;
	}
	public MemberVO login(String id,String password) throws SQLException{
		MemberVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql=
		   "select name,address from member where id=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,password);
			rs=pstmt.executeQuery();
			if(rs.next()){
				vo=new MemberVO(id,password,rs.getString(1),rs.getString(2));
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return vo;
	}
	public ArrayList<MemberVO> getAllMember() throws SQLException{
		ArrayList<MemberVO> list=new ArrayList<MemberVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql="select * from member";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new MemberVO(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4)));
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return list;
	}
	
	//true媛� 由ы꽩�릺硫� �빐�떦 id媛믪씠 �씠誘� �뵒鍮꾩뿉 ���옣�릺�뼱 �엳�쓬�쓣 �쓽誘�
	//�뵲�씪�꽌 true�씪 �븣�뒗 id以묐났... 洹� �븘�씠�뵒瑜� �궗�슜�븷 �닔 �뾾�룄濡� �쑀�룄..checkId()�옄諛붿뒪�겕由쏀듃�뿉�꽌 泥섎━
	public boolean isExist(String id) throws SQLException{
		boolean result=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql="select count(*) from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()){				
				if(rs.getInt(1)>0)
					result=true;
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return result;
	}
}

















