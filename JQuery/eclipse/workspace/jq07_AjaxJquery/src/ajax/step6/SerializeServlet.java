package ajax.step6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SerializeServlet")
public class SerializeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// field
	private Map<String, String> map = new HashMap<String, String>();
	
	@Override
	public void init() throws ServletException {
		map.put("ajax", "Woojeong Kim");		// Woojeong Kim�� ID�� ajax
		map.put("jquery", "Friendship Kim");	// Friendship Kim�� ID�� jquery
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String command = request.getParameter("command");
		if(command.equals("register")){
			String name = request.getParameter("name");
			String addr = request.getParameter("addr");
			out.println(addr + "�� ��� " + name + "�� ���� ��ī��ī");
		}else{		// command�� idcheck�� ��
			String id = request.getParameter("id");
			
			if(map.get(id) == null)		// id�� �ش��ϴ� �̸��� ���� ���
				out.print(false);		// form���κ��� ���� ID�� DB�� ����
			else
				out.print(true);
			
		}
		out.close();
	}
}
