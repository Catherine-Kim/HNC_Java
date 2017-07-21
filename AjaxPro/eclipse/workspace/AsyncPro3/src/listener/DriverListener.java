package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DriverListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {		
		
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String ODriver=sce.getServletContext().getInitParameter("ODriver");
		System.out.println(ODriver+ "  를 dd로 부터 읽어 초기화작업 완료~~~~");
		
		try{
			Class.forName(ODriver);
			System.out.println("Driver Loading....");
		}catch(ClassNotFoundException e){
			System.out.println("해당 드라이버를 로딩하지 못했습니다..");
		}
		
	}

}















