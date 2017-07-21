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

	// field �߰�
	private int count;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		// GET ����� ��û�� ��� request.setCharacterEncoding("utf-8");�� �� �� ����
		// �׷��� �츮�� server.xml�� URIEncoding=utf-8 �� �߰��Ѱ���
		response.setContentType("text/html;charset=utf-8");
		// response���� ��û�� ������ ��ܼ� ���ϱ� �ѱ�ó�� �������
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		out.println(id + " / " + pass + " <br/>Count :: " + count++);
	}
}
