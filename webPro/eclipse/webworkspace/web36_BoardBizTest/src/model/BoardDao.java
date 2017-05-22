package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {
	//private Connection conn;
	private static BoardDao dao = new BoardDao();
	private BoardDao(){}
	public static BoardDao getInstance(){
		return dao;
	}

	public Connection getConnection() throws SQLException{
		return DataSourceManager.getInstance().getConnection();
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null)
			ps.close();
		if(conn !=null)
			conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn) 
																throws SQLException{
		if(rs != null)
			rs.close();
		closeAll(ps, conn);
	}
	/////////////////////////////////////Business Login/////////////////////////////
	
	/*
	 * 게시판의 글을 작성하는 로직..
	 */
	public void posting(BoardVO vo)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.INSERT_POSTING);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getPassword());
			ps.setString(4, vo.getContent());
			System.out.println(ps.executeUpdate() + " post inserted");
		}finally{
			closeAll(ps, conn);
		}
	}//posting()
	
	public BoardVO getPostingByNo(int no)throws SQLException{
		BoardVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.SELECT_POSTING);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()){
				vo = new BoardVO(no,
								 rs.getString("title"),
								 rs.getString("writer"),
								 rs.getString("content"),
								 rs.getInt("hits"),
								 rs.getString("time_posted"));
			}
			
		}finally{
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	
	
	
	/*		
	public ArrayList<BoardVO> getPostingList() throws SQLException{
		
	}//
	
	public boolean checkPassword(int no,String password)throws SQLException{
		
	}	//
	
	public void deletePosting(int no)throws SQLException{
		
	}//
	
	public void updatePosting(BoardVO vo)throws SQLException{

	}*/
	
	public static void main(String[] ar)throws Exception{
		/*BoardDao.getInstance().posting(
				new BoardVO("첫번째 글", "하바리", "777", "오늘은 불금"));*/
		System.out.println(BoardDao.getInstance().getPostingByNo(1));
		
	}		
}


























