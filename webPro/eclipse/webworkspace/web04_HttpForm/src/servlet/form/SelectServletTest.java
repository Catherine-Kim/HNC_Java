package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelectServletTest() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		String hobby = request.getParameter("hobby");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println(name + "<br/>");
		out.println(pass + "<br/>");
		out.println(hobby + "<br/>");
		out.println("</body></html>");
		
		out.close();
	}
}
