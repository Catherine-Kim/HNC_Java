package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import vo.Person;

public class TestController extends MultiActionController {
	public ModelAndView findBoard(HttpServletRequest request, HttpServletResponse response) 
																		throws Exception {
		// Business Logic 돌았다고 치자
		System.out.println("findBoard() from TestController being called");
		return new ModelAndView("board_result");
	}

	public ModelAndView findProduct(HttpServletRequest request, HttpServletResponse response) 
																		throws Exception {
		System.out.println("findProduct() from TestController being called");
		return new ModelAndView("product_result");
	}

	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) 
																		throws Exception {
		System.out.println("register() from TestController being called");
		return new ModelAndView("JsonView", "person", new Person("김무성", "노룩패스"));
	}
}
