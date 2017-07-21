package ajax.step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ������ VO�� �ʿ��ѵ� VO ���� �غ����� 
		// ��ü Ÿ���� �����͸� ���� �� �ִ� ��ü : JSONObject(json.jar �ȿ� ����)
		JSONObject json = new JSONObject();
		json.put("name", "Friendship");	// map ������� ������ ���� �� ����
		json.put("age", 24);
		json.put("address", "Colorado");
		
		out.print(json); // ��ü�� ���۵�
		// success: function(data) ���� data�� json�� ������
	}
}
