package jq08_UI_Demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping("testMorning.do")
	public ModelAndView breakfast(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BREAKFAST business logic call..");
		return new ModelAndView("tabspage/breakfast", "menu", "Cream Soup");
	}

	@RequestMapping("testLunch.do")
	public ModelAndView lunch(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		System.out.println("LUNCH business logic call..");
		return new ModelAndView("tabspage/lunch", "menu", "Sandwitch");
	}

	@RequestMapping("testDinner.do")
	public ModelAndView supper(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		System.out.println("DINNER business logic call..");
		return new ModelAndView("tabspage/dinner", "menu", "Aglio E Oli");
	}
}
