package solve2.src;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

public class ServiceAdvice{
	Log log = LogFactory.getLog(getClass());
	
	// �޼ҵ��� ���ڰ����� Advice�� ������ �����Ѵ�.
	public void logWeaving(ProceedingJoinPoint pjp) throws Throwable{	// �������´�� ������ ����
		log.info("Check AOP before ...");
		Object obj = pjp.proceed();	// �� �������� Target�� Business Logic�� ȣ���
		log.info("Check AOP After ...");
	}
}
