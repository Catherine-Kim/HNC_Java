package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;

public class WriteController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception {
		// form으로부터 받을 수 없는 값 : no, time_posted, hits
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		BoardVO pvo = new BoardVO(title, writer, password, content);
		
		System.out.println("[WriteController] posting 전 vo의 no : " + pvo.getNo());
		BoardDao.getInstance().posting(pvo);
		System.out.println("[WriteController] posting 후 vo의 no : " + pvo.getNo());             
		
		String path = "DispatcherServlet?command=showContent&&no="+pvo.getNo();
		return new ModelAndView(path, true);	// redirect
	}
}
