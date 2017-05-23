package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
										HttpServletResponse response) throws Exception {
		// Business Logic 돌아갔다 치자
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("message", "Hello Spring MVC~! :)");
		
		return mv;
	}
}
