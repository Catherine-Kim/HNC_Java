package servlet.header;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletHeader3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HttpServletHeader3() {
    	
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		// 0. 한글처리(양방향)
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		// 1. form에 입력된 값 받기
		String name = request.getParameter("myName");
		String addr = request.getParameter("addr");
		
		// 2. 입력된 이름을 웹으로 출력
		out.println("<html><body>");
		out.println("<b> My Name : " + name + "</b><p>");
		out.println("<b> My Addrss : " + addr + "</b><p>");
		
		
		// 3. HttpServletRequest에 담긴 Header 정보를 다 받아와서 웹으로 출력
		Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()){
			String key = en.nextElement();
			String value = request.getHeader(key);
			out.println(key + " : " + value + "<br/>");
		}
		out.println("</body></html>");
		
		// 4. out 닫기
		out.close();
	}
}
