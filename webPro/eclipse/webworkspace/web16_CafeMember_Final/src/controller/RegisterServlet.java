package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<MemberVO> list = new ArrayList<MemberVO>();
       
    public RegisterServlet() {
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException{
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id, name, password, address);
		MemberDAO dao = MemberDAO.getInstance();
		
		try {
			dao.registerMember(vo);
			System.out.println("[SUCCESS] registerMember() from RegisterServlet");
			response.sendRedirect("ShowAll");
		} catch (SQLException e) {
			System.out.println("[FAIL] registerMember() from RegisterServlet");
			response.sendRedirect("./error/error.html");
		}
	}
}
