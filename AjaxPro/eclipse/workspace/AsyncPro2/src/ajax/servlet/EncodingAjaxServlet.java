package ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EncodingAjaxServlet")
public class EncodingAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		// 응답할 때 캐시에 있는 찌꺼기를 쓰지 않겠다는 뜻(Ajax에서 해주면 좋음)
		response.setHeader("Cache-Control", "no-cache");
		
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		
		// 브라우저로부터 받은 값 디코딩
		id = URLDecoder.decode(id, "utf-8");
		
		// 그림 보고싶으니까 출력을 지연시켜보자
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		out.print(id);	// 이 때 HTML의 callback()으로 응답
		//HTML에서 이 부분의 값을 받을 때 xhr.responseText 가 필요
		
		out.close();
	}
}
