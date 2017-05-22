package api3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor{
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		// invocation을 이용해서 Target의 메소드명을 가져와보자
		String targetMName = invocation.getMethod().getName();		
		
		StopWatch sw = new StopWatch(); // 어떤 기능이 호출되서 실행될때까지의 시간을 재는
		sw.start();						// Springframework에서 제공하는 클래스
		
		System.out.println("[LOG] Method : " + targetMName + " is called");
		Object obj = invocation.proceed();		// Target method 호출
		
		sw.stop();
		System.out.println("[LOG] Method : " + targetMName + " has been completed");
		System.out.println("[LOG] Time : " + sw.getTotalTimeSeconds() + " sec");
		
		return obj;
	}
}
