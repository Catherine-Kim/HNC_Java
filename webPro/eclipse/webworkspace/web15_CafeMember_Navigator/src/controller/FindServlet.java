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
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		try {
			MemberVO vo = dao.findByIdMember(id);
			
			// ************************ 1. forward() ************************
			/*// ServletRequest binding
			request.setAttribute("vo", vo);
			
			// forwarding을 이용한 페이지 이동 방법
			RequestDispatcher rd = request.getRequestDispatcher("findOK.jsp");
			rd.forward(request, response);
			
			out.println("<h2>Forwarding 방법으로 페이지를 이동</h2>");*/
			
			// ************************ 2. include() ************************
			RequestDispatcher rd = request.getRequestDispatcher("include.jsp");
			rd.include(request, response);
			
			out.println("<h2>including 방법으로 페이지를 이동</h2>");
			
			out.close();
		} catch (SQLException e) {
		}
	}
}
