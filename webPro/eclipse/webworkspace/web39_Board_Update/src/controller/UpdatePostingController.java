package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;

public class UpdatePostingController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) 
																		throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardVO bvo = new BoardVO();
		bvo.setNo(no);
		bvo.setTitle(title);
		bvo.setWriter(writer);
		bvo.setContent(content);
		BoardDao.getInstance().updatePosting(bvo);
		
		return new ModelAndView("DispatcherServlet?command=showContent");
	}
}
