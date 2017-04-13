package web.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloGeneric3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor='pink'><h2> Hello HttpServer....!!!"
															+ "</h2></body></http>");
		out.close();
	}
}
