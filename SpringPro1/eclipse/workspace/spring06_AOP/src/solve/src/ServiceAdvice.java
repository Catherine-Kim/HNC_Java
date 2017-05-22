package solve.src;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServiceAdvice implements MethodInterceptor{
	Log log = LogFactory.getLog(getClass());
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {	
		log.info("Check ... Business Logic Call Before ...");
		
		Object obj = invocation.proceed();	// 얘가 어떤 일을 하는지가 가장 중요
		System.out.println(obj + " ??");

		log.info("Check ... Business Logic Call After ...");
		
		return obj;
	}
}
