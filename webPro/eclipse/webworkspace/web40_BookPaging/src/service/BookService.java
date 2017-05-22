package service;

import java.sql.SQLException;
import java.util.ArrayList;

import model.BookDao;
import model.BookVO;
import model.PagingBean;

/*
 * db에 직접적으로 데이타를 요청하는 클래스가 아니라....(Persistence Layer가 아니다)
 * BookDao가 biz logic()을 이용해서 데이타를 요청해오면 /
 * 그 데이타를 가공해서 사용하는 로직을 담고있다.
 * ::
 * BookDao와 마찬가지로 싱글톤으로 작성..
 */
public class BookService {
	private BookDao dao;
	
	private static BookService service = new BookService();
	private BookService(){
		dao=BookDao.getInstance(); //주입...
	}
	public static BookService getInstance(){
		return service;
	}
	////////////Service Layer의 비지니스 로직 작성 ////////////////////////
	//register :: BookDao의 posting()과 동일.
	public void register(BookVO vo)throws SQLException{
		dao.posting(vo);
	}
	
	public ListVO getBookList(String pageNo) throws SQLException{
		int pn = 1; //index 에서 연결될떄는 무조건 최신페이지부터 보여줘야 한다.
		//index 화면이 아니라 내가 특정한 페이지를 클릭해서 들어간다면...
		if(pageNo != null)
			pn = Integer.parseInt(pageNo);
		
		ArrayList<BookVO> list=dao.getBookList(pn);
		int total=dao.getTotalBookCount();
		
		PagingBean pb = new PagingBean(total, pn);
		return new ListVO(list, pb);
		
	}
}




















