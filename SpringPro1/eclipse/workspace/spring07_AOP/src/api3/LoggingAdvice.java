package api3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor{
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		// invocation�� �̿��ؼ� Target�� �޼ҵ���� �����ͺ���
		String targetMName = invocation.getMethod().getName();		
		
		StopWatch sw = new StopWatch(); // � ����� ȣ��Ǽ� ����ɶ������� �ð��� ���
		sw.start();						// Springframework���� �����ϴ� Ŭ����
		
		System.out.println("[LOG] Method : " + targetMName + " is called");
		Object obj = invocation.proceed();		// Target method ȣ��
		
		sw.stop();
		System.out.println("[LOG] Method : " + targetMName + " has been completed");
		System.out.println("[LOG] Time : " + sw.getTotalTimeSeconds() + " sec");
		
		return obj;
	}
}
