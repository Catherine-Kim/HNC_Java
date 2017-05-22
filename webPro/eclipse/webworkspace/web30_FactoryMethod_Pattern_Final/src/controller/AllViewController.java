package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class AllViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception {
		ArrayList<MemberVO> list = MemberDAO.getInstance().getAllMember();
		System.out.println("[SUCCESS] getAllMember() from AllViewController");
		request.setAttribute("list", list);
		
		return new ModelAndView("allView.jsp");
	}

}
