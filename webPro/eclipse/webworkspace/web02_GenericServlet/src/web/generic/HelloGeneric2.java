package web.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class HelloGeneric2
 */
public class HelloGeneric2 extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    
	public void service(ServletRequest request, ServletResponse response) 
												throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor='yellow'><h2>");
		out.println("Hiiiiiiiiiiiiiii Generic2~!!");
		out.println("</h2></body></html>");
	}
}
