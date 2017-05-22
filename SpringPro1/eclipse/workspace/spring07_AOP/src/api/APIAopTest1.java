package api;

import org.springframework.aop.framework.ProxyFactoryBean;

public class APIAopTest1 {
	public static void main(String[] args) {
		// 1. Target, Advice, Factory 생성
		MessageImpl target = new MessageImpl();
		MessageAdvice advice = new MessageAdvice();
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		
		// 2. Factory에 Target과 Advice 추가
		pfBean.setTarget(target);
		pfBean.addAdvice(advice);
		
		// 3. Factory에서 Target을 받아옴
		Message pfTarget = (Message) pfBean.getObject();
		
		// 4. Factory의 Business Logic을 호출 -> Advice의 Method가 Weaving됨
		System.out.println("pfTarget의 Business Logic 호출 ::");
		pfTarget.print();
		pfTarget.message();
		
		System.out.println("----------------------------------------------");
		System.out.println("그냥 target의 Business Logic 호출 ::");
		target.print();
		target.message();
	}
}
