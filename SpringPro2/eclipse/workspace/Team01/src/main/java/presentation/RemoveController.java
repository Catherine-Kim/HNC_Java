package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import persistence.UserDao;
import persistence.UserDaoImpl;
import service.UserService;



public class RemoveController implements Controller{
	private UserDao userDao;
	
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getParameter("userId");
	      String path = null;
	      
	      int result= userDao.removeUser(userId);
	      if(result==1){
	         path = "WEB-INF/result/remove_success.jsp";
	      }else if(result==0){
	         path = "WEB-INF/result/remove_fail.jsp";
	      }
	      
	      return new ModelAndView(path, "userId", userId);
	}

}
