package ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FindNickServlet")
public class FindNickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// field �߰�
	private HashMap<String, String> nickName = new HashMap<String, String>();
	
	@Override
	public void init() throws ServletException {
		nickName.put("ũ����Ż", "������");
		nickName.put("�糪", "�ڼ���");
		nickName.put("���丮��", "���丮��");
		nickName.put("����", "����");
		nickName.put("����", "����");
	}	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name= request.getParameter("name");
		name = URLDecoder.decode(name, "utf-8");
		String nick = nickName.get(name);
		
		if(!nickName.containsKey(name))
			out.print("�� �̸��� �ش��ϴ� ���� ����");
		else
			out.print(nick);
		
		out.close();
	}
}
