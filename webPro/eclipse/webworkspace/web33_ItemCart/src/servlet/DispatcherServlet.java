package servlet;

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
		// hidden을 매번 쓰지 않고 값 받기
		
		String requestURI = request.getRequestURI();
		System.out.println("getRequestURI() :: " + requestURI);
		// web31_ItemCart/itemList.do 가 출력됨
		
		String contextPath = request.getContextPath();
		System.out.println("getContextPath() :: " + contextPath);
		// web31_ItemCart 가 출력됨
		
		// itemList.do만 추출하는 것이 목적
		String command = requestURI.substring(contextPath.length());
		
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
				response.sendRedirect(mv.getUrl());
			else
				request.getRequestDispatcher(mv.getUrl()).forward(request, response);
		}
	}
}
