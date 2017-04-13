package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckBoxServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckBoxServletTest() {
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String kisu = request.getParameter("kisu");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
		String[] menus = request.getParameterValues("menu");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h3> 너 기수 : " + kisu + "</h3>");
		out.println("<h3> 너 이름 : " + name + "</h3>");
		out.println("<h3> 너 성별 : " + gender + "</h3>");
		out.println("<h3> 저녁 메뉴 : </h3>");
		for(String m : menus){
			out.println("<h3>" + m + "</h3>");
		}
		out.println("</body></html>");
		
		out.close();
	}
}
