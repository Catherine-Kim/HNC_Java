package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 해당 클래스(Filter)를 작성한 후, web.xml에 등록을 해야한다.
 * <filter>
 *   <filter-name>
 *   <filter-class>
 * </filter>
 * <filter-mapping>
 *   <filter-name>
 *   <url-pattern>
 * </filter-mapping>
 */

public class EncodingFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
							FilterChain chain) throws IOException, ServletException {
		// 사전작업
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");	
		
		// 사전작업에서 수행한 내용이 서버상의 다음 Servlet들에게 계속 적용되도록 chaining으로
		// 연결한 것
		chain.doFilter(request, response);
		
		// 사후작업
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}
