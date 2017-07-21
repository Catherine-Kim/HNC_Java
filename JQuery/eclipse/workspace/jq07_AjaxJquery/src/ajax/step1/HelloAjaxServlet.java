package ajax.step1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloAjaxServlet")
public class HelloAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HelloAjaxServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		// html에 응답받는 부분이 없으니 일단 요청만 받아서 콘솔에 넘어온 값 출력
		System.out.println(request.getParameter("name"));
	}
}
