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

	// field 추가
	private HashMap<String, String> nickName = new HashMap<String, String>();
	
	@Override
	public void init() throws ServletException {
		nickName.put("크리스탈", "정수정");
		nickName.put("루나", "박선영");
		nickName.put("빅토리아", "빅토리아");
		nickName.put("엠버", "엠버");
		nickName.put("설리", "진리");
	}	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name= request.getParameter("name");
		name = URLDecoder.decode(name, "utf-8");
		String nick = nickName.get(name);
		
		if(!nickName.containsKey(name))
			out.print("이 이름에 해당하는 별명 없음");
		else
			out.print(nick);
		
		out.close();
	}
}
