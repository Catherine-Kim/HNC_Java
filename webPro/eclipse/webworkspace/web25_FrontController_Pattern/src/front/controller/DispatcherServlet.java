package front.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO dao = MemberDAO.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException {
		doProcess(request, response);
	} // doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException {
		doProcess(request, response);
	} // doPost()

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException {
		String command = request.getParameter("command");
		String path = "index.jsp"; 
		// 만약 error page가 있다면 error page를 default로 해줘도 ok

		try {
			if (command.equals("find"))
				path = find(request, response);
			else if (command.equals("login"))
				path = login(request, response);
			else if(command.equals("allView"))
				path = allView(request, response);
			else if(command.equals("logout"))
				path = logout(request, response);
			else if(command.equals("udpate"))
				path = update(request, response);
			else if(command.equals("register"))
				path = register(request, response);
			else if(command.equals("idcheck"))
				path = idcheck(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	} // doProcess()

	protected String find(HttpServletRequest request, HttpServletResponse response) 
								throws ServletException, IOException, SQLException {
		MemberVO rvo = dao.findByIdMember(request.getParameter("id"));
		System.out.println("[SUCCESS] findByIdMember() from DispatcherServlet");
		if(rvo != null){
			request.setAttribute("mvo", rvo);
			return "find_ok.jsp";
		}else{
			return "find_fail.jsp";
		}
	} // find()

	protected String login(HttpServletRequest request, HttpServletResponse response)
								throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberVO rvo = dao.login(id, password);
		System.out.println("[SUCCESS] login() from DispatcherServlet");
		if(rvo != null){
			request.getSession().setAttribute("mvo", rvo);
			return "login_ok.jsp";
		}else{
			return "login_fail.jsp";
		}
	} // login()

	protected String register(HttpServletRequest request, HttpServletResponse response)
								throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, name, password, address);
		
		dao.registerMember(pvo);
		System.out.println("[SUCCESS] registerMember() from DispatcherServlet");
		return "register_result.jsp";		
	} // register()
	
	protected String allView(HttpServletRequest request, HttpServletResponse response)
								throws ServletException, IOException, SQLException {
		ArrayList<MemberVO> list = dao.getAllMember();
		System.out.println("[SUCCESS] getAllMember() from DispatcherServlet");
		request.setAttribute("list", list);
		
		return "allView.jsp";
	} // allView()
	
	protected String update(HttpServletRequest request, HttpServletResponse response)
								throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, name, password, address);
		
		dao.updateMember(pvo);
		request.getSession().setAttribute("mvo", pvo);
		System.out.println("[SUCCESS] updateMember() from DispatcherServlet");
		
		return "update_result.jsp";
	} // update()
	
	protected String logout(HttpServletRequest request, HttpServletResponse response)
								throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("mvo") != null){
			session.invalidate();
		}
		return "logout.jsp";
	} // logout()
	
	protected String idcheck(HttpServletRequest request, HttpServletResponse response)
								throws ServletException, IOException, SQLException {
		boolean found = dao.idExist(request.getParameter("id"));
		System.out.println("[SUCCESS] idExist() from DispatcherServlet");
		request.setAttribute("found", found);
		return "idcheck.jsp";
	} // idcheck()
}