package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import persistence.User;
import service.UserService;
import service.UserServiceImpl;

public class ShowUserContorller implements Controller{
	private UserService userService;
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = userService.getUser(request.getParameter("user_id"));
		return new ModelAndView("WEB-INF/result/show_user.jsp", "user", user);
	}

}
