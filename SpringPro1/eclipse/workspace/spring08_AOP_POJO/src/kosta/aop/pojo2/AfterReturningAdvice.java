package kosta.aop.pojo2;

import org.aspectj.lang.JoinPoint;

public class AfterReturningAdvice {
	public void afterMethod(JoinPoint jp, Object ret) throws Throwable{
		// Target Ŭ���� �̸��� �޼ҵ�� ������
		String targetCName = jp.getTarget().getClass().getName();	// Target Ŭ������
		String targetMName = jp.getSignature().getName();			// Target�� �޼ҵ��
		System.out.println("[Target Class] " + targetCName);
		System.out.println("[Target Method] " + targetMName);
	}
}
