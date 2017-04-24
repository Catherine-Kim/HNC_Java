package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Date now = new Date();
		String id = "KOSTA";
		
		// 1) Cookie 생성
		Cookie c1 = new Cookie("now", now + " "); 
		// method를 쓰지 않고 String 처리
		// String이 아닌 것과 String이 만나면 String으로 convert 됨
		
		Cookie c2 = new Cookie("id", id);
		
		// 2) Cookie 보내기
		response.addCookie(c1);
		response.addCookie(c2);
		
		// Cookie의 유효시간을 지정
		//c2.setMaxAge(24*60*60); 	// 하루로 지정
		c2.setMaxAge(0);
		
		// 출력
		out.println("<html><body>");
		out.println("<h2>Cookie Creating Time :: " + now + "</h2><br/>");
		out.println("<h2>ID :: " + id + "</h2><br/>");
		out.println("<a href=GetCookieTest>GetCookieTest</a>");
		out.println("</body></html>");
		out.close();
	}
}
