package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import persistence.User;
import service.UserService;

public class UpdateController implements Controller{
	private UserService userService;
	
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}



	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String path = "result/update.jsp";
		
		User user = userService.getUser(id);
		
		if(password != "")
			user.setPassword(password);
		if(name != "")
			user.setUserName(name);
		if(age != 0)
			user.setAge(age);
		
		System.out.println("user from update :: " + user);
		int result = userService.updateUser(user);
		System.out.println("RESULT :: " + result);
		if(result == 1){
			path = "showUser.do?user_id="+id;
		}
	
		return new ModelAndView(path);
	}
}
