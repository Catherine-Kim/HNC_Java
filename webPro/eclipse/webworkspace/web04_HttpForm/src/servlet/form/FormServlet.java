package servlet.form;
// http://localhost:8888/web04_HttpForm/FrmServlet
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		// 0. PrintWriter 객체를 리턴받기 전에 한글처리가 되어 있어야 한다.
		// (양방향 모두 한글처리 해주어야 함)
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 1. 브라우저로 응답하기 위한 객체를 리턴받음
	 	PrintWriter pw = response.getWriter();
	 	
	 	// 2. form에 입력된 값을 서버에서 받음
	 	String name = request.getParameter("name");
	 	String addr = request.getParameter("addr");
	 	String kisu = request.getParameter("kisu");
	 	
	 	// 3. 받아온 정보를 웹상으로 출력
	 	pw.println("<html><body>");
	 	pw.println("<h2>당신의 정보들입니다.</h2>");
	 	pw.println("<h4>당신의 이름 : " + name + "</h4><br/>");
	 	pw.println("<h4>당신의 주소 : " + addr + "</h4><br/>");
	 	pw.println("<h4>당신의 기수 : " + kisu + "</h4>");
	 	pw.println("</body></html>");
	 	
	 	// 4. 닫기
	 	pw.close();
	}
}
