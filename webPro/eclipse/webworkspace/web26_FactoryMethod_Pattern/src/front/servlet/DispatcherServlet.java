package front.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Product;
import controller.ProductFactory;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		String command = request.getParameter("command");
		String path = "error.jsp";
		
		Product product = ProductFactory.getInstance().createProduct(command);
		
		try{
			path = product.execute(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
}
