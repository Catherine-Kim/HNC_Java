package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextReading1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// field
	private ArrayList<String> userInfo;
	private ServletContext context;
	
	@Override
	public void init() throws ServletException {
		// ArrayList를 리턴받아 그 안의 데이터 뽑아낸다.
		context = getServletContext();
		System.out.println("ServletContext 리턴 완료");
		
		userInfo = (ArrayList<String>) context.getAttribute("userInfo");
		System.out.println("UserInfo 리턴 완료");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// PrintWriter 리턴 받기
		PrintWriter out = response.getWriter();
		
		out.println("<html><body bgcolor='green'>");
		out.println("<h3>ID : " + userInfo.get(0) + "</h3><br/>");
		out.println("<h3>PW : " + userInfo.get(1) + "</h3><br/>");
		out.println("<h3>NAME : " + userInfo.get(2) + "</h3><br/>");
		out.println("</body></html>");
	}
}
