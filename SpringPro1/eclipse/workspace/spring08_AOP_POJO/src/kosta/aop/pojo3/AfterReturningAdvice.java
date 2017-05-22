package kosta.aop.pojo3;

import org.aspectj.lang.JoinPoint;

public class AfterReturningAdvice {
	public void afterMethod(JoinPoint jp, Object ret) throws Throwable{
		// Target 클래스 이름과 메소드명 얻어오기
		String targetCName = jp.getTarget().getClass().getName();	// Target 클래스명
		String targetMName = jp.getSignature().getName();			// Target의 메소드명
		System.out.println("[Target Class] " + targetCName);
		System.out.println("[Target Method] " + targetMName);
	}
}
