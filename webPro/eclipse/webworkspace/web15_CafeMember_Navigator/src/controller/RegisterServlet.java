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

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException{
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		PrintWriter out = response.getWriter();
		
		MemberVO newMember = new MemberVO(id, name, password, address);
		
		MemberDAO dao = MemberDAO.getInstance();
		try {
			dao.registerMember(newMember);
			 
			/*// JSP로 작업을 부탁할 RequestDispatcher를 인스턴스화 합니다.
			RequestDispatcher view = request.getRequestDispatcher("registerOK.jsp");
			 
			// RequestDispatcher는 컨테이너에게 JSP를 준비하라고 요청합니다. 그 다음 JSP에게 request/response 객체를 넘깁니다.
			view.forward(request, response);*/
			
			out.println("<html><body>");
			out.println("<a href=registerOK.jsp?name="+ name +">결과 페이지 보러가깅><</a>");
		} catch (SQLException e) {
			System.out.println("[FAIL] registerMember() from RegisterServlet");
			out.println("<a href=index.html>다시 Home으로...ㅠㅠ</a>");
		}
		out.println("</body></html>");
	}
}
