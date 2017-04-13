package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. ServletContext를 리턴받아온다.
// 2. form에 입력된 값 받아온다.
// 3. Collection 생성하고 여기에 받아온 값 저장한다.
// 4. Collection을 ServletContext에 binding한다.
// 5. 페이지를 연결한다.(응답)

public class ServletContextWriting1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// field
	private ArrayList<String> userInfo;
	private ServletContext context;

    @Override
    public void init() throws ServletException {
    	System.out.println("init() 호출 by Container");
    	
    	// getServletContext() - ServletConfig의 메소드, 얘도 쓸 수 있음(상속받았으니까)
    	context = getServletContext();
    	System.out.println("ServletContext 리턴 완료");
    	
    	userInfo = new ArrayList<String>();
    	System.out.println("ArrayList 생성 완료");
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException {
		// 양방향 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// PrintWriter 리턴 받기
		PrintWriter out = response.getWriter();
		
		// form에 입력된 값을 각각 받아서 userInfo에 저장
		//Enumeration<String> en = request.getParameterNames();
		Enumeration<String> en = context.getInitParameterNames();
		while(en.hasMoreElements()){
			String key = en.nextElement();
			//String value = request.getParameter(key);
			String value = context.getInitParameter(key);
			userInfo.add(value);
		}
		
		// userInfo를 ServletContext에 write
		context.setAttribute("userInfo", userInfo); // 객체명과 똑같은 key값을 주는 게 좋음
													// 나중에 헷갈리지 않게(convention)
		
		out.println("<html><body bgcolor='yellow'>");
		out.println("<b>**************** Communication between Servlets ****************</b><br/>");
		out.println("<b>사용자의 정보가 ServletContext에 binding 되었습니다.</b><br/><br/>");
		out.println("<a href='SC2'>사용자 정보 조회</a>");
		out.println("</body></html>");
	}
}
