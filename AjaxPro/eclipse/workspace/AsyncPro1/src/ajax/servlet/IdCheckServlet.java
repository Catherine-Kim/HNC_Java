package ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

@WebServlet("/IdCheckServlet")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8;"); // 응답 시에만 한글 처리
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		
		try{
			boolean flag = MemberDAO.getInstance().idExist(id);
			out.print(flag);	// println() 아니고 print()
			// step1_idcheck.html의 callback() 함수 안으로
		}catch(Exception e){	
			e.printStackTrace();
		}
		
		out.close();
	}
}
