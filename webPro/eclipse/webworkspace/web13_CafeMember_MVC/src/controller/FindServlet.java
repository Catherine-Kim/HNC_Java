package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		try {
			MemberVO vo = dao.findByIdMember(id);
		
			if(vo != null){
				// 리턴타입이 있으니 Data binding을 해보자(GET 방식으로 일일이 보내지 말고)
				getServletContext().setAttribute("vo", vo);
				
				out.println("<h2>회원 정보 찾음</h2>");
				out.println("<a href=findOK.jsp>회원 정보 보러가기</a>");
			}else{
				out.println("<h2>해당 ID의 회원은 존재하지 않는다네</h2>");
			}
		} catch (SQLException e) {
		}
		
	}
}
