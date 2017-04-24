package servlet.direct;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException {
		/*
		 * checkbox를 선택한 경우와 선택하지 않은 경우로 나뉜다
		 * 1) checkbox 선택한 경우 : resultView page로 이동 → forward
		 * 2) error 페이지로 이동 → redirect
		 */
		
		String choice = request.getParameter("choice");
		if(choice == null){			// checkbox 선택하지 않은 경우
			response.sendRedirect("./error/error.html");
		}else{						// checkbox 선택하지 않은 경우
			RequestDispatcher rd = request.getRequestDispatcher("redirect_result.jsp");
			rd.forward(request, response);;
		}
	}
}
