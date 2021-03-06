package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;

public class ListController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response)
																	throws Exception {
		ArrayList<BoardVO> list = BoardDao.getInstance().getPostingList();
		request.setAttribute("list", list);
		
		ModelAndView mv = new ModelAndView();
		mv.setPath("show_list.jsp");
		
		return mv;
	}
}
