package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// 1. Session을 받아온다.
		HttpSession session = request.getSession();
		System.out.println("[SUCCESS] Session 받아오기 from SecondServlet");
		
		// 2. Session에 id라는 이름으로 받아온 값이 null이 아니라면
		// 그 값을 받아와서 웹으로 출력한다.
		out.println("<html><body>");
		out.println("<h2 align='center'>SecondServlet</h2><p><br/>");
		if(session.getAttribute("id") != null){
			out.println("<h3>JSESSIONID : " + session.getId() + "</h3><p><br/>");
			out.println("<h3>ID : " + session.getAttribute("id") + "</h3><p>");
			System.out.println("[SUCCESS] JSESSIONID와 'id' 값 받아오기 from "
																	+ "SecondServlet");
		}else{
			System.out.println("[FAIL] JSESSIONID와 'id' 값 받아오기 from SecondServlet");
			response.sendRedirect("session.html");
		}
		out.println("</body></html>");
		out.close();
	}
}
