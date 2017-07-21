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
		
		// 원래는 VO가 필요한데 VO 없이 해볼거임 
		// 객체 타입의 데이터를 담을 수 있는 객체 : JSONObject(json.jar 안에 있음)
		JSONObject json = new JSONObject();
		json.put("name", "Friendship");	// map 방식으로 데이터 담을 수 있음
		json.put("age", 24);
		json.put("address", "Colorado");
		
		out.print(json); // 객체가 전송됨
		// success: function(data) 에서 data에 json이 담길것임
	}
}
