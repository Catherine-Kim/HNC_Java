package servlet.context;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextInit22 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// field
	private ServletContext context;

	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출");
		context = getServletContext();
		Enumeration<String> en = context.getAttributeNames();
		while(en.hasMoreElements()){
			String name = en.nextElement();
			String value = context.getInitParameter(name);
			System.out.println(name + ", " + value);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
	
	}
}
