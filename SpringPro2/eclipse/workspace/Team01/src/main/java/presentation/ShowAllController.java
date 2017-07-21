package presentation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import persistence.User;
import service.UserService;


public class ShowAllController implements Controller{

	private UserService userService;
	
	public void setUserServiceImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * form에 입력된 값 받아서 ok라는 파일에 이름과 주소가 출력되도록
		 */
		List<User> userList = userService.getUserList();
		return new ModelAndView("WEB-INF/result/show_all_result.jsp", "userList",userList);
	}

}
