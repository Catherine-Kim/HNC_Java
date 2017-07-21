package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindMemberController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, 
									HttpServletResponse response) throws Exception {
		// filter∞° ¿÷¿∏π«∑Œ response.setContentType() æ» «ÿ¡‡µµ µ 
		
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		
		MemberVO rvo = MemberDAO.getInstance().findMemberById(id);
		out.print(rvo.getName() + " / " + rvo.getAddress());
		
		return null;
	}
}
