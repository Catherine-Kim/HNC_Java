package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	@RequestMapping("/form.do")
	public ModelAndView anno(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("name");
		String addr = request.getParameter("address");
		return new ModelAndView("ok", "message", name + ", " + addr);
	}
}
