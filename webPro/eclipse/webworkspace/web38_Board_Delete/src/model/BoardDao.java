package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BoardDao {
	private DataSource ds;
	private static BoardDao dao = new BoardDao();
	private BoardDao(){
		ds = DataSourceManager.getInstance().getConnection();
	}
	public static BoardDao getInstance(){
		return dao;
	}

	public Connection getConn() throws SQLException{
		return ds.getConnection();	
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
	public void posting(BoardVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			ps = conn.prepareStatement(StringQuery.INSERT_POSTING);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getPassword());
			ps.setString(4, vo.getContent());
			System.out.println(ps.executeUpdate() + " post inserted");

			// 현재 sequence 가져오는 쿼리문 추가
			// 동일한 Connection 연결해서 nextVal, currValㅇ르 가져올 수 있다.
			// session이 달라지면(Connection이 달라지면) currVal을 가져올 수 없다.
			ps = conn.prepareStatement(StringQuery.CURRENT_NO);
			rs = ps.executeQuery();
			if (rs.next()) {
				vo.setNo(rs.getInt(1));
			}
			System.out.println("[SUCCESS] vo 완성 from getPostingByNo()");

		} finally {
			closeAll(rs, ps, conn);
		}
	}// posting()
	
	public BoardVO getPostingByNo(int no) throws SQLException{
		BoardVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = getConn();
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
	} // getPostingByNo()
	
	public ArrayList<BoardVO> getPostingList() throws SQLException {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = getConn();
			ps = conn.prepareStatement(StringQuery.PAGE_LIST);
			rs = ps.executeQuery();
			while(rs.next()){
				// no, title, writer, to_char(time_posted, 'yyyy.mm.dd'), hits
				list.add(new BoardVO(rs.getInt("no"),
									 rs.getString("title"),
									 rs.getString("writer"),
									 "",
									 rs.getInt("hits"),
									 rs.getString("time_posted")
						));
			}			
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
	} // getPostingList()
	
	
	public boolean checkPassword(int no, String password)throws SQLException{
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			conn = getConn();
			ps = conn.prepareStatement(StringQuery.PASS_CHECK);
			ps.setInt(1, no);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
				if(rs.getInt(1) != 0) result=true;
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		
		return result;
	} // checkPassword()
	
	public void deletePosting(int no)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = getConn();
			ps = conn.prepareStatement(StringQuery.DELETE_POSTING);
			ps.setInt(1, no);
			System.out.println(ps.executeUpdate() + " row deleted");
		}finally{
			closeAll(ps, conn);
		}
	} // deletePosting()
	
	/*		
	public boolean checkPassword(int no,String password)throws SQLException{
		
	}	//
	
	public void deletePosting(int no)throws SQLException{
		
	}//
	
	public void updatePosting(BoardVO vo)throws SQLException{

	}*/
	
	/*
	public static void main(String[] ar)throws Exception{
		BoardDao.getInstance().posting(
				new BoardVO("첫번째 글", "하바리", "777", "오늘은 불금"));
		System.out.println(BoardDao.getInstance().getPostingByNo(1));
		
	}	*/	
}


























