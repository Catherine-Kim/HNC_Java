package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

public class IdCheckController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, 
									HttpServletResponse response) throws Exception {
		response.setHeader("Cache-Control", "no-cache");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		boolean flag = MemberDAO.getInstance().isExist(id);
		
		out.print(flag);
		
		return null;
	}
}












