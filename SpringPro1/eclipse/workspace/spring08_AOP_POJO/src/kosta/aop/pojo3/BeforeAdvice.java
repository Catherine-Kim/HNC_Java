package kosta.aop.pojo3;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
	public void beforeMethod(JoinPoint jp) throws Throwable{	// ���ڰ� �ϳ��� ��
		String targetCName = jp.getSignature().getName();			// Target Ŭ���� �̸�
		String targetMName = jp.getTarget().getClass().getName();	// Target �޼ҵ� �̸�
		System.out.println("[BeforeAdvice] Target Class : " + targetCName);
		System.out.println("[BeforeAdvice] Target Method : " + targetMName);		
	}
}
