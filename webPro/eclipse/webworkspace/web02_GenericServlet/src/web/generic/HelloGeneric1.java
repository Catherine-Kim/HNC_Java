package web.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloGeneric1 extends GenericServlet{
	@Override
	public void service(ServletRequest request, ServletResponse response) 
												throws ServletException, IOException {
		// Client에게 Hello Generic을 출력
		PrintWriter out = response.getWriter();
		// printWriter : 브라우저로 출력할 수 있는 기능을 가진 객체

		out.println("<html><body bgcolor='cyan'><h2>");
		out.println("Hello Generic!!!!!!!!!!!!!!!!");
		out.println("</h2></body></html>");
		
		out.close();
	}
}
