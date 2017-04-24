package servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		boolean found = false;
		/*
		 * GET 방식으로 전달된 id 값 받기
		 * MemberDAO 리턴받기
		 * Business Logic 호출 : idExist() → boolean 리턴 받기
		 * Binding
		 * Navigation - forwarding
		 */
		
		String id = request.getParameter("id");
		MemberDAO dao = MemberDAO.getInstance();
		
		try{
			found = dao.idExist(id);
			request.setAttribute("found", found);
			request.getRequestDispatcher("idcheck.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
