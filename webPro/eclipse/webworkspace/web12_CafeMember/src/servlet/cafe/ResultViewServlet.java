package servlet.cafe;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.PersonVO;

public class ResultViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //field
	private List<PersonVO> list;
	
    public ResultViewServlet() {
    	
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("ServletContext 위치값 :: " + getServletContext());
    	list = (List<PersonVO>) getServletContext().getAttribute("list");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println(request.getParameter("name") + " 님, 카페에 가입하신 걸 환영<br/><br/>");
		out.println("<h2>*********** 전체 카페 회원 명단 ***********</h2><p>");
		out.println("<table border=2>");
		for(int i = 0; i < list.size(); i++){
			out.println("<tr><td>" + (i + 1) + "</td>");
			out.println("<td>" + list.get(i).getName() + "</td>");
			out.println("<td>" + list.get(i).getAge() + "</td></tr>");
		}
		out.println("</table>");
		out.close();
	}
}
