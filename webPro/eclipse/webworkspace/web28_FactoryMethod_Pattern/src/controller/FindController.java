package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception {
		String path = "find_fail.jsp";
		
		// 1. form 값 받기
		String id = request.getParameter("id");
		
		// 2. Business Logic
		MemberVO rvo = MemberDAO.getInstance().findByIdMember(id);
		if(rvo != null){
			// 3. Binding
			request.setAttribute("mvo", rvo);
			path = "find_ok.jsp";
		}
		
		return path;
	}
}
