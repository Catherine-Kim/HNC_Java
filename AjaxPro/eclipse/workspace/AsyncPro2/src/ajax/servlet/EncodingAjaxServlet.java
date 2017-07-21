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
		
		// ������ �� ĳ�ÿ� �ִ� ��⸦ ���� �ʰڴٴ� ��(Ajax���� ���ָ� ����)
		response.setHeader("Cache-Control", "no-cache");
		
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		
		// �������κ��� ���� �� ���ڵ�
		id = URLDecoder.decode(id, "utf-8");
		
		// �׸� ��������ϱ� ����� �������Ѻ���
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		out.print(id);	// �� �� HTML�� callback()���� ����
		//HTML���� �� �κ��� ���� ���� �� xhr.responseText �� �ʿ�
		
		out.close();
	}
}
