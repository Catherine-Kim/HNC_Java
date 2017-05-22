package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberVO;

public class UpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String path = "index.jsp";
		
		MemberVO pvo = new MemberVO(id, name, password, address);
		
		HttpSession session = request.getSession();
		if(session != null){
			session.setAttribute("mvo", pvo);
			path = "update_result.jsp";
		}
		
		return new ModelAndView(path);
	}
}
