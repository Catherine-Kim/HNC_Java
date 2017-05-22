package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		MemberVO pvo = new MemberVO(id, name, password, address);
		
		try{
			MemberDAO.getInstance().updateMember(pvo);
			
			// 이 부분을 절대로 빼먹으면 안된다능. 수정 코드에는 절대 session이 빠질 수 없음
			// update와 login은 무조건 session이 나와야 함
			HttpSession session = request.getSession();
			if(session != null){
				session.setAttribute("mvo", pvo);
				request.getRequestDispatcher("update_result.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
