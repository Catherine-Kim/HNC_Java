package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;
import service.ListVO;

public class ListController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// 1. 페이지 넘버 받아오기(없으면 default는 1 페이지로 하자)
		// 2. BookService의 getBookList()를 호출
		// 3. ListVO를 리턴받아서 binding
		// 4. Navigation - show_list.jsp
		
		String pageNo = request.getParameter("pageNo");
		System.out.println("ListControlelr page number :: " + pageNo);
		
		ListVO lvo = BookService.getInstance().getBookList(pageNo);  
		request.setAttribute("lvo", lvo);
		
		return new ModelAndView("show_list.jsp");
	}
}
















