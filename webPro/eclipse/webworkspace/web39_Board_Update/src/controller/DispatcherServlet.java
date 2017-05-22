package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.HandlerMapping;
import controller.ModelAndView;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {

		String command = request.getParameter("command");
		
		// Factory 리턴받기
		ModelAndView mv = null;
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try{
			// controller의 handle() 수행 & ModelAndView 얻어내기
	 		mv = controller.handle(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		// mv 갖고 할 거 하기
		if(mv != null){
			if(mv.isRedirect())
				response.sendRedirect(mv.getPath());
			else
				request.getRequestDispatcher(mv.getPath()).forward(request, response);
		}
	}
}
