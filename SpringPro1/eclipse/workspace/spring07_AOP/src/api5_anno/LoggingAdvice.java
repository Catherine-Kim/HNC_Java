package api5_anno;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class LoggingAdvice{
	
	@Around("execution(* api5_anno.Message*.say*(..))")
	public void helloWeave(ProceedingJoinPoint pjp) throws Throwable {
		// ProceedingJoinPoint�� Around ���
		// Around �̿��� ����� JoinPoint
		
		// pjp�� �̿��ؼ� Target�� �޼ҵ���� �����ͺ���
		String targetMName = pjp.getSignature().getName();
		
		// pjp�� �̿��ؼ� Target Ŭ������ �̸��� �����ͺ���
		String targetCName = pjp.getTarget().getClass().getName();	// Target Ŭ������ FQCN
		
		StopWatch sw = new StopWatch(); // � ����� ȣ��Ǽ� ����ɶ������� �ð��� ���
		sw.start();						// Springframework���� �����ϴ� Ŭ����
		
		System.out.println("[LOG] Method : " + targetMName + " is called from " + 
																			targetCName);
		Object obj = pjp.proceed();		// Target method ȣ��
		
		sw.stop();
		System.out.println("[LOG] Method : " + targetMName + " has been completed");
		System.out.println("[LOG] Time : " + sw.getTotalTimeSeconds() + " sec");
	}
}
