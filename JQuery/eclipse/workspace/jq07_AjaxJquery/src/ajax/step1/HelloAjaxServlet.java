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
		// html�� ����޴� �κ��� ������ �ϴ� ��û�� �޾Ƽ� �ֿܼ� �Ѿ�� �� ���
		System.out.println(request.getParameter("name"));
	}
}
