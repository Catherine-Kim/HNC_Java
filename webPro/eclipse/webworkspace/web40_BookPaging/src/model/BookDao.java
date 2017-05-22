package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

/**
 * Persistence Layer에서 디비에 Access하는 비지니스 로직을 담고있는 model
 * DataSourceManager를 통해서 DataSource를 리턴받고 / 
 * DataSource의 getConnection()을 통해서 Connection을 얻는다
 * ::
 * 지금까지는 ServerSide의 FrontController를 통해서 직접적으로 dao의 Biz()를 호출받았지만
 * 이제부터는 Service Layer와의 연결이 시작될 것이다.
 * ::
 * Service Layer에 대해서 알아보는 계기로 삼자
 */
public class BookDao {
	private DataSource ds;
	private static BookDao dao = new BookDao();
	private BookDao(){
		ds=DataSourceManager.getInstance().getConnection();
	}
	public static BookDao getInstance(){
		return dao;
	}
	
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null)
			ps.close();
		if(conn !=null)
			conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException{
		if(rs != null)
			rs.close();
		closeAll(ps, conn);
	}//closeAll()
	
	///////////////////// 비지니스 로직 ///////////////////////////////////
	/**
	 * 하나의 책을 등록하는 기능 :: posting(BookVO) : void
	 * 책을 하나 등록한 후 생성된 시퀀스를 BookVO에 다시 세팅
	 */
	public void posting(BookVO vo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=  null;
		try{
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.INSERT_BOOK);
			ps.setString(1, vo.getTitle());
			ps.setInt(2, vo.getPrice());
			
			int row = ps.executeUpdate();
			
			ps = conn.prepareStatement(StringQuery.CURRENT_NO);
			rs = ps.executeQuery();
			if(rs.next()) vo.setBookNo(rs.getInt(1));
			
			System.out.println("dao...posting()..."+row);
		}finally{
			closeAll(rs, ps, conn);
		}
	}//
	
	public ArrayList<BookVO> getBookList(int pageNo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=  null;
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		try{
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.BOOK_LIST);
			ps.setInt(1, pageNo);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new BookVO(rs.getInt("book_no"), rs.getString("title"), rs.getInt("price")));
			}

		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
	}
	/**
	 * 이 로직은 페이지 생성하는데 필요...
	   즉, Service Layer에서 필요한 로직이다.
	 * 전체 책의 갯수를 조회하는 기능
	 * 해당 로직을 보면서 Persistence, Service Layer의 차이점을 
	   나중에 생각해보자
	 */
	public int getTotalBookCount() throws SQLException{
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=  null;
		int count=-1;
		try{
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.TOTAL_COUNT);
			rs = ps.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		}finally{
			closeAll(rs, ps, conn);
		}
		return count;
	}
}