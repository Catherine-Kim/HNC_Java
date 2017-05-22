package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

public class IdCheckController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		boolean found = false;
		
		found = MemberDAO.getInstance().idExist(id);
		request.setAttribute("found", found);
		return new ModelAndView("idcheck.jsp");
	}
}
