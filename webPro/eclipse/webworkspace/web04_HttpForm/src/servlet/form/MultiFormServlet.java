package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultiFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MultiFormServlet() {
     
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		Enumeration<String> en = request.getParameterNames();
		out.println("<html><body>");
		while(en.hasMoreElements()){
			String formName = en.nextElement();
			if(formName.equals("hobby")){
				String[] hobbies = request.getParameterValues(formName);
				out.println("<h3> " + formName + " ::  ");
				for(String h : hobbies){
					out.print(h + " ");
				}
				out.println("</h3>");
			}else{
				out.println("<h3> " + formName + " ::  " + 
											request.getParameter(formName) + "</h3>");
			}
		}
		out.println("</body></html>");
	}
}
