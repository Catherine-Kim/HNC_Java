package web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyInputServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		System.out.println(name);
		
		request.setAttribute("name", name);
		request.setAttribute("tel", tel);
		request.setAttribute("address", address);
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/mis_result.jsp");
		dispatcher.forward(request, response);
	}
}
