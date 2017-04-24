package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		
		// 1. 생성된 Session을 하나 받아온다.
		HttpSession session = request.getSession();
		System.out.println("[SUCCESS] Session 받아오기 from FirstServlet");
		
		// 2. 콘솔로 Session의 JSessionID 값 출력한다.
		System.out.println("JSESSIONID: " + session.getId());
		
		// 3. form에서 입력된 값이라고 치고(form 안 만들었음), Session에 "id"라는 이름으로
		// "kosta"를 저장(binding)
		session.setAttribute("id", "kosta");
		System.out.println("[SUCCESS] Session에 값(kosta) binding from FirstServlet");
		
		// 4. forwarding 방식으로 페이지 이동(Second)
		RequestDispatcher rd = request.getRequestDispatcher("Second");
		rd.forward(request, response);
		System.out.println("[SUCCESS] SecondServlet으로 forwarding from FirstServlet");
	}
}
