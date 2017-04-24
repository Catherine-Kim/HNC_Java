package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyDriverListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("[CALLING] contextInitialized()");		
		// ServletContext를 리턴받아서 getInitParameter를 적용
		// Driver Loading
		try {
			Class.forName(sce.getServletContext().getInitParameter("ODriver"));
			System.out.println("[SUCCESS] Driver Loading");
		} catch (ClassNotFoundException e) {
			System.out.println("[FAIL] Driver Loading");
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("[CALLING] contextDestroyed()");	
		
	}
}
