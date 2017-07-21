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
		map.put("ajax", "Woojeong Kim");		// Woojeong Kim의 ID는 ajax
		map.put("jquery", "Friendship Kim");	// Friendship Kim의 ID는 jquery
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String command = request.getParameter("command");
		if(command.equals("register")){
			String name = request.getParameter("name");
			String addr = request.getParameter("addr");
			out.println(addr + "에 사는 " + name + "님 가입 추카추카");
		}else{		// command가 idcheck일 때
			String id = request.getParameter("id");
			
			if(map.get(id) == null)		// id에 해당하는 이름이 없는 경우
				out.print(false);		// form으로부터 받은 ID가 DB에 없음
			else
				out.print(true);
			
		}
		out.close();
	}
}
