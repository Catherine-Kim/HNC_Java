package servlet.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfig1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// fields
	private String name;
	private String addr;
	private Enumeration<String> en;

    public ServletConfig1() {
        System.out.println("1. 서블릿 생성...");
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("2. init() 호출...");
    	
    	// getInitParameter() - ServletConfig를 상속받았으므로 얘도 가지고 있는 기능
    	// 그냥 쓰면 됨    	
    	// A Servlet Configuration using getInitParameter()
    	name = getInitParameter("NAME");
    	addr = getInitParameter("ADDR");
    	System.out.println("NAME : " + name + ", ADDR : " + addr);
    	
    	en = getInitParameterNames();                                                          
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		System.out.println("3. doGet() 호출...");
		PrintWriter out = response.getWriter();
		
		/*out.println("<html><body><h2>A Servlet Configuration... </h2><p>");
		out.println("Your Name :: " + name + "<br/>");
		out.println("Your Address :: " + addr + "<br/>");*/
		out.println("getInitParameterNames() :: <br/>");
		while(en.hasMoreElements()){
			String enstr = en.nextElement();
			out.println(enstr + "<br/>"); 
		}                                                                                  
		out.println("</body></html>");
		
		out.close();
	}
}
