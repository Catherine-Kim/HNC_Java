package api2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageAdvice implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// Business Logic 호출 전
		System.out.println("[BEFORE] Business Logic");
		
		// Target의 메소드
		Object obj = invocation.proceed();
		if(obj != null){	// Business Logic의 리턴타입이 void가 아니라면
			System.out.println("리턴된 값 :: " + obj);
		}
		
		// Business Logic 호출 후
		System.out.println("[AFTER] Business Logic");
		return obj;
	}
}
