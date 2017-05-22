package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class RegisterController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String path = "register_result.jsp";
		
		MemberVO pvo = new MemberVO(id, name, password, path);
		MemberDAO.getInstance().registerMember(pvo);
		System.out.println("[SUCCESS] registerMember() from RegisterController");
		
		return new ModelAndView(path, true);
	}
}
