package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FromController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
									HttpServletResponse response) throws Exception {
		
		// form의 입력값 받아서 Business Logic 돌렸다 치자
		// ok라는 파일에 이름과 주소가 출력
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		return new ModelAndView("ok", "message", name + ", " + address);
	}

}
