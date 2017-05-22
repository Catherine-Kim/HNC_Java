package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "index.jsp";
		
		try{
			MemberVO rvo = MemberDAO.getInstance().findByIdMember(id);
			System.out.println("[SUCCESS] findByIdMember() from FindServlet");
			if(rvo != null){
				request.setAttribute("mvo", rvo);
				path = "find_ok.jsp";
			}else{
				path = "find_fail.jsp";
			}
		}catch(Exception e){
			System.out.println("[FAIL] findByIdMember() from FindServlet");
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
