package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet이 아니고 Interface
public interface Product {
	public String execute(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception;
}
