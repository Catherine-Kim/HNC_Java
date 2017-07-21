package ajax.step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServletAjax2")
public class HelloServletAjax2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// 3초 지연 후 응답
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 응답 - ajax02.html의 success:function()부분으로 전송
		out.print(id + " " + password);
		out.close();
	}
}
