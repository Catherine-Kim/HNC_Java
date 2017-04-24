package servlet.session;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException {
		// 1. form에 입력된 값 받아오기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		// 2. DAO instance 리턴받기
		MemberDAO dao = MemberDAO.getInstance();

		try {
			// 3. Login() 호출 - vo 리턴받기
			MemberVO rvo = dao.login(id, pass);
			System.out.println("[SUCCESS] login() from LoginServlet");
			
			//4. Session 리턴받기 - JSESSIONID도 확인해야하니 콘솔에 출력
			HttpSession session = request.getSession();
			System.out.println("[SUCCESS] Session 받아오기(JSESSIONID : " + 
																	session.getId());
			
			// 5. vo가 null이 아니라면 Session에 binding
			session.setAttribute("vo", rvo);
			System.out.println("[SUCCESS] setAttribute() from LoginServlet");
			
			// 6. Navigator - login_result.jsp로 redirect
			response.sendRedirect("login_result.jsp");
		} catch (Exception e) {
			System.out.println("[FAIL] login() from LoginServlet");
		}
	}
}

