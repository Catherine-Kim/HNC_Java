package kosta.aop.pojo3;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
	public void beforeMethod(JoinPoint jp) throws Throwable{	// 인자값 하나면 됨
		String targetCName = jp.getSignature().getName();			// Target 클래스 이름
		String targetMName = jp.getTarget().getClass().getName();	// Target 메소드 이름
		System.out.println("[BeforeAdvice] Target Class : " + targetCName);
		System.out.println("[BeforeAdvice] Target Method : " + targetMName);		
	}
}
