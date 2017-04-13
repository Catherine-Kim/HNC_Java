package servlet.header;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletHeader1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public HttpServletHeader1() {
		System.out.println("생성자 호출... by Container");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		System.out.println("doGet() 호출 ... by Container");
		// 응답할 때 한글 처리
		response.setContentType("text/html;charset=utf-8");
		
		// PrintWriter 객체 생성
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor='yellow'>");
		out.println("<h2>Header Information Printing...</h2><p>");
		Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()){
			String key = en.nextElement();
			String value = request.getHeader(key);
			out.println(key + " : " + value + "<br/>");			
		}
		out.println("</body></html>");
		out.close();
	}
}
