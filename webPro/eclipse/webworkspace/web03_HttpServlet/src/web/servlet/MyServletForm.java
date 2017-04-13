package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html);charset=utf-8");
		
		// 1. 웹 브라우저에 출력하는 기능을 가진 PrintWriter 생성
		PrintWriter out = response.getWriter();
		
		// 2. 웹 브라우저에 받은 값 출력
		out.println("<html><body><h3> Your Login Information :: </p3>");
		out.println("<h5>ID : " + request.getParameter("id")  + "</h5>");
		out.println("<h5>PW : " + request.getParameter("password") + "</h5>");
		
		out.close();
	}
}
