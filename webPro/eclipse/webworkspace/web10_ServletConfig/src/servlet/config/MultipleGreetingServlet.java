package servlet.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultipleGreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// field
	private String message;

    public MultipleGreetingServlet() {
    	System.out.println("1. 서블릿 생성...");
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("2. init() 호출...");
    	
    	message = getInitParameter("greeting");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		System.out.println("3. doPost() 호출...");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("myname");
		
		out.println("<html><body><h2>Welcome to the Winter Olympic!</h2><p>");
		out.println("<b>" + name + "</b> ... Welcome!!<br/>");
		out.println(message);
		out.println("</body></html>");
		
		out.close();
	}
}
