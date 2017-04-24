package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
		
		MemberDAO dao = MemberDAO.getInstance();
		
		try {
			MemberVO vo = dao.findByIdMember(id);
			System.out.println("[SUCCESS] findByIdMember() from FindServlet");
			
			// ServletRequest binding
			request.setAttribute("vo", vo);
			
			// forwarding을 이용한 페이지 이동 방법
			RequestDispatcher rd = request.getRequestDispatcher("find_ok.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			System.out.println("[FAIL] findByIdMember() from FindServlet");
			response.sendRedirect("./error/error.html");
		}
	}
}
