package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import vo.Person;

public class TestController extends MultiActionController{
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("insert - 동기통신");
		return new ModelAndView("insert_ok");
	}

	public ModelAndView searchId(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("searchId - 비동기통신");
		return new ModelAndView("JsonView", "person", new Person("김무성", "노룩패스"));
	}
}
