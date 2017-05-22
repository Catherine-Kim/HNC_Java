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
		// ProceedingJoinPoint는 Around 방식
		// Around 이외의 방식은 JoinPoint
		
		// pjp를 이용해서 Target의 메소드명을 가져와보자
		String targetMName = pjp.getSignature().getName();
		
		// pjp를 이용해서 Target 클래스의 이름을 가져와보자
		String targetCName = pjp.getTarget().getClass().getName();	// Target 클래스의 FQCN
		
		StopWatch sw = new StopWatch(); // 어떤 기능이 호출되서 실행될때까지의 시간을 재는
		sw.start();						// Springframework에서 제공하는 클래스
		
		System.out.println("[LOG] Method : " + targetMName + " is called from " + 
																			targetCName);
		Object obj = pjp.proceed();		// Target method 호출
		
		sw.stop();
		System.out.println("[LOG] Method : " + targetMName + " has been completed");
		System.out.println("[LOG] Time : " + sw.getTotalTimeSeconds() + " sec");
	}
}
