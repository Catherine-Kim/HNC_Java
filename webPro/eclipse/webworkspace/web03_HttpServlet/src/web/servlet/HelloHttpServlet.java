package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloHttpServlet
 */
public class HelloHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String wasName = "Apache Tomcat";

    public HelloHttpServlet() {
    	System.out.println(wasName + " 생성자 호출됨....");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		System.out.println("doGet() 호출됨....");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		// 1. PrintWriter 객체 리턴받음
		PrintWriter out = response.getWriter();
		
		// 2. 웹으로 출력
		out.println("<html><body><p>Hello HttpServlet!!!!</p></body></html>");
		out.close();
	}
}
