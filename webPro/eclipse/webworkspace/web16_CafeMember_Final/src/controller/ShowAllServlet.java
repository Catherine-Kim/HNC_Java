package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class ShowAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		
		try {
			// ServletContext에 저장되어있던 것을 가져옴
			ArrayList<MemberVO> list = dao.getAllMember();
			
			// request에 set(forwarding이니까)
			request.setAttribute("list", list);
			System.out.println("[SUCCESS] getAllMembers() from ShowAllServlet");
		} catch (SQLException e) {
			System.out.println("[FAIL] getAllMembers() from ShowAllServlet");
		}
		
		// JSP로 작업을 부탁할 RequestDispatcher를 인스턴스화 합니다.
		RequestDispatcher view = request.getRequestDispatcher("show_all.jsp");

		// RequestDispatcher는 컨테이너에게 JSP를 준비하라고 요청합니다. 그 다음 JSP에게
		// request/response 객체를 넘깁니다.
		view.forward(request, response);
	}
}
