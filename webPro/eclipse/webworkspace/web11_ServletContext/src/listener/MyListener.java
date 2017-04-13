package listener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{
	// field
	private ServletContext context;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("1. contextInitialized() 호출");
		
		context = sce.getServletContext();
		System.out.println("2. ServletContext 리턴 받음");
		
		String fileName = context.getInitParameter("path");
		System.out.println("3. getInitParameter(path) 호출 :: " + fileName);
		
		InputStream is = null;
		BufferedReader br = null;
		
		try{
			is = context.getResourceAsStream(fileName);	// InputStream 리턴
			br = new BufferedReader(new InputStreamReader(is));
			System.out.println("4. Stream 생성");
			
			String line = null;
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
		}catch(Exception e){
			
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed() 호출");
	}
}
