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
	// field 추가
	private Map<String, String> map = new HashMap<String, String>();
	
	@Override
	public void init() throws ServletException {
		map.put("득호", "Washington");
		map.put("요섭", "Tokyo");
		map.put("태현", "Oxford");
		map.put("동근", "California");
		map.put("서윤", "Seoul");
		map.put("하람", "Texas");
		map.put("우정", "Oslo");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");	// 응답 시 한글 처리
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		out.print(map.get(name));		// 이름에 해당하는 value(주소)를 뿌림
		out.close();
	}
}
