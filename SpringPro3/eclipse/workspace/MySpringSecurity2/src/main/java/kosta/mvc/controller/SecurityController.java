package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping("/")
	public String home(){
		return "index"; 	// WEB-INF/views/index.jsp
	}
	
	@RequestMapping("/home/main")
	public String homeMain(){
		return "homeMain"; 	// WEB-INF/views/index.jsp
	}
	
	@RequestMapping("/member/main")
	public String memberMain(){
		return "memberMain"; 	// WEB-INF/views/index.jsp
	}
	
	@RequestMapping("/manager/main")
	public String managerMain(){
		return "managerMain"; 	// WEB-INF/views/index.jsp
	}
	
	@RequestMapping("/admin/main")
	public String adminMain(){
		return "adminMain"; 	// WEB-INF/views/index.jsp
	}
}
