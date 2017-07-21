package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class IdListController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, 
									HttpServletResponse response) throws Exception {
		response.setHeader("Cache-Control", "no-cache");
		
		ArrayList<String> idList = MemberDAO.getInstance().getIdList();
		
		request.setAttribute("idList", idList);
		
		return new ModelAndView("show_idList.jsp");
	}
}
