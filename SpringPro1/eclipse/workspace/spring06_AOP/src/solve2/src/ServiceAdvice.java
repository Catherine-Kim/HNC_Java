package solve2.src;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

public class ServiceAdvice{
	Log log = LogFactory.getLog(getClass());
	
	// 메소드의 인자값으로 Advice의 유형을 결정한다.
	public void logWeaving(ProceedingJoinPoint pjp) throws Throwable{	// 생각나는대로 변수명 지음
		log.info("Check AOP before ...");
		Object obj = pjp.proceed();	// 이 시점에서 Target의 Business Logic이 호출됨
		log.info("Check AOP After ...");
	}
}
