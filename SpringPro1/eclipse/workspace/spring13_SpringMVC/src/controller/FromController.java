package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FromController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
									HttpServletResponse response) throws Exception {
		
		// form�� �Է°� �޾Ƽ� Business Logic ���ȴ� ġ��
		// ok��� ���Ͽ� �̸��� �ּҰ� ���
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		return new ModelAndView("ok", "message", name + ", " + address);
	}

}
