package servlet.cafe;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.PersonVO;

public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// field
	List<PersonVO> list = Collections.synchronizedList(new ArrayList<PersonVO>()); 
	// ArrayList 동기화처리
	
    public EntranceServlet() {
    	System.out.println("[CALLING] constructor");
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("[CALLING] init()");
    	System.out.println("ServletContext의 위치값 : " + getServletContext()); 
    	// ServletContext가 정상적으로 만들어졌는지 확인
    	getServletContext().setAttribute("list", list);
    	System.out.println("[SUCCESS] Binding list to Attribute");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		System.out.println("[CALLING] doGet()");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("[SUCCESS] get parameters from form");
		
		list.add(new PersonVO(name, age));
		System.out.println("[SUCCESS] add VO to list");
		
		out.println(name + " 님이 Cafe에 들어오셨습니당");
		out.println("<a href=ResultView?name=" + name + "> 다음 서블릿 페이지로 이동. 멤버 명단 보러가기</a>");
		System.out.println("[SUCCESS] Navigation");
		
		out.close();
	}
}
