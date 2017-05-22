package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) 
														throws Exception;	
	// path 리턴
	// HttpServletRequest와 HttpServletResponse 객체 hasing
}
