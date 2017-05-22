package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class LoginController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "login_fail.jsp";
		
		MemberVO rvo = MemberDAO.getInstance().login(id, password);
		if(rvo != null){
			System.out.println("[SUCCESS] login() from LoginController");
			request.getSession().setAttribute("mvo", rvo);
			path = "login_ok.jsp";
		}
		
		return new ModelAndView(path);
	}
}
