package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;

public class UpdateViewController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) 
																		{
		/* 1. 수정하고자 하는 no를 받아온다.
		 * 2. no를 인자값으로 해당 게시글 리턴하는 biz() - rvo 리턴받음
		 * 3. bvo binding - request
		 * 4. navigation - update.jsp
		 */
		
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO rvo;
		try {
			rvo = BoardDao.getInstance().getPostingByNo(no);
			request.setAttribute("bvo", rvo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new ModelAndView("update.jsp");
	}
}
