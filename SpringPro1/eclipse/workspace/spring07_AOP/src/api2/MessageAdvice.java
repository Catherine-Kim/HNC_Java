package api2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageAdvice implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// Business Logic ȣ�� ��
		System.out.println("[BEFORE] Business Logic");
		
		// Target�� �޼ҵ�
		Object obj = invocation.proceed();
		if(obj != null){	// Business Logic�� ����Ÿ���� void�� �ƴ϶��
			System.out.println("���ϵ� �� :: " + obj);
		}
		
		// Business Logic ȣ�� ��
		System.out.println("[AFTER] Business Logic");
		return obj;
	}
}
