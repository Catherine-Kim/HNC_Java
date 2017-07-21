package ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCountServlet")
public class GetCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// field 추가
	private int count;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		// GET 방식의 요청일 경우 request.setCharacterEncoding("utf-8");을 할 수 없음
		// 그래서 우리는 server.xml에 URIEncoding=utf-8 을 추가한거임
		response.setContentType("text/html;charset=utf-8");
		// response에는 요청한 사항이 담겨서 가니까 한글처리 해줘야지
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		out.println(id + " / " + pass + " <br/>Count :: " + count++);
	}
}
