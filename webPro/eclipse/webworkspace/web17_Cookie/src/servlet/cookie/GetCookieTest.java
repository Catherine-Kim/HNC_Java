package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h2>Getting Cookie Information</h2><p>");
		
		// Client가 보낸 Cookie 받기
		Cookie[] cs = request.getCookies();
		
		for(Cookie c : cs){
			out.println(c.getName() + ", " + c.getValue());
		}
		
		out.close();
	}
}
