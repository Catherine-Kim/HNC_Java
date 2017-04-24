package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindAddrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		// 1) form 값 받기
		// 2) DAO 리턴 받기
		// 3) Business Logic - login() 호출
		//    - findMemberByAddr(String addr) 작성
		// 4) ArrayList 반환
		// 5) Binding
		// 6) Navigation : addr_list.jsp - table 형식으로 출력
		
		String address = request.getParameter("address");
		
		MemberDAO dao = MemberDAO.getInstance();
		try {
			ArrayList<MemberVO> foundPeople = dao.findByAddress(address);
			getServletContext().setAttribute("foundPeople", foundPeople);
			
			RequestDispatcher rd = request.getRequestDispatcher("addr_list.jsp");
			rd.forward(request, response);
			System.out.println("[SUCCESS] findByAddress() - FindAddrServlet");
		} catch (SQLException e) {
			System.out.println("[FAIL] findByAddress() - FindAddrServlet");
			response.sendRedirect("./error/error.html");
		}
	}
}
