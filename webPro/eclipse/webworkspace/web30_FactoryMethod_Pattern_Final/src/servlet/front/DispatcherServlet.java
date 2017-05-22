package servlet.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.HandlerMapping;
import controller.ModelAndView;

@WebServlet("/DispatcherServlet")
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
		String path = "index.jsp";
		ModelAndView mv = null;			// ModelAndView 필드 추가
		boolean isRedirect = true;		// 페이지 이동 방법을 정하는 boolean 필드 추가
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try{
			mv = controller.execute(request, response);		// ModelAndView 리턴받음
			path = mv.getPath();							// path와 isRedirect가져오기
			isRedirect = mv.isRedirect();
		}catch(Exception e){
			
		}
		
		// isRedirect에 따라 페이지 이동
		if(isRedirect){
			response.sendRedirect(path);
		}else{
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
}
