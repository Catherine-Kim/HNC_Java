package ajax.step3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// field �߰�
	private Map<String, String> map = new HashMap<String, String>();
	
	@Override
	public void init() throws ServletException {
		map.put("��ȣ", "Washington");
		map.put("�伷", "Tokyo");
		map.put("����", "Oxford");
		map.put("����", "California");
		map.put("����", "Seoul");
		map.put("�϶�", "Texas");
		map.put("����", "Oslo");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");	// ���� �� �ѱ� ó��
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		out.print(map.get(name));		// �̸��� �ش��ϴ� value(�ּ�)�� �Ѹ�
		out.close();
	}
}
