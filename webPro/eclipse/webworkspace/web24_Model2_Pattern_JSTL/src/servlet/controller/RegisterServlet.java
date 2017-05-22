package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, name, password, address);
		MemberDAO dao = MemberDAO.getInstance();
		
		try {
			dao.registerMember(pvo);
			System.out.println("[SUCCESS] registerMember() from RegisterServlet");
			request.getRequestDispatcher("register_result.jsp").forward(request,
																			response);
			
		} catch (SQLException e) {
			System.out.println("[FAIL] registerMember() from RegisterServlet");
			e.printStackTrace();
		}
	}
}
