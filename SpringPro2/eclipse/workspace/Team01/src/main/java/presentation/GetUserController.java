package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import persistence.User;
import service.UserService;

public class GetUserController implements Controller{
	// field
	private UserService userService;
	
	// setter
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("id");
		String path = "update_who.jsp";
		
		User user = userService.getUser(userId);
		System.out.println("USER :: " + user );
		if(user == null){
			path = "WEB-INF/result/update_who.jsp?match="+false;
		}else{
			path = "WEB-INF/result/update.jsp";
		}
			
		return new ModelAndView(path, "user", user);
	}
	
}
