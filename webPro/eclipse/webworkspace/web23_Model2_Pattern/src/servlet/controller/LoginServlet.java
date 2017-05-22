package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "login_fail.jsp";		// 프로그램은 기본값이 false임을 전제로 함
		
		MemberDAO dao = MemberDAO.getInstance();
		
		try {
			MemberVO rvo = dao.login(id, password);
			System.out.println("[SUCCESS] login() from LoginServlet");
			if(rvo!=null){
				HttpSession session = request.getSession();
				session.setAttribute("mvo", rvo);
				path = "login_ok.jsp";
			}
		} catch (SQLException e) {
			System.out.println("[FAIL] login() from LoginServlet");
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
