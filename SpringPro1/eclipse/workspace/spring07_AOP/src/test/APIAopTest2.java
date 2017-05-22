package test;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import api2.Message;
import api2.MessageAdvice;
import api2.MessageImpl;

public class APIAopTest2 {
	public static void main(String[] args) {
		// 1. Factory 생성
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		
		// 2. Factory에 Target 추가
		pfBean.setTarget(new MessageImpl());
		
		// 3. Weaving될 Target의 PointCut을 지정
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();	
		// Weaving되는 메소드를 메소드의 이름으로 매치시키겠다
		pointcut.setMappedName("sear*");
		
		// 4. Factory에 Advisor 추가 (Advisor = Advice + Pointcut)
		pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new MessageAdvice()));
		
		// 5. Target의 Business Logic 호출
		Message pfTarget = (Message) pfBean.getObject();
		//System.out.println(pfTarget.message());
		pfTarget.searchAddress("판교");
	}
}
