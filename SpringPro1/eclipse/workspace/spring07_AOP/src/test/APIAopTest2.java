package test;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import api2.Message;
import api2.MessageAdvice;
import api2.MessageImpl;

public class APIAopTest2 {
	public static void main(String[] args) {
		// 1. Factory ����
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		
		// 2. Factory�� Target �߰�
		pfBean.setTarget(new MessageImpl());
		
		// 3. Weaving�� Target�� PointCut�� ����
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();	
		// Weaving�Ǵ� �޼ҵ带 �޼ҵ��� �̸����� ��ġ��Ű�ڴ�
		pointcut.setMappedName("sear*");
		
		// 4. Factory�� Advisor �߰� (Advisor = Advice + Pointcut)
		pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new MessageAdvice()));
		
		// 5. Target�� Business Logic ȣ��
		Message pfTarget = (Message) pfBean.getObject();
		//System.out.println(pfTarget.message());
		pfTarget.searchAddress("�Ǳ�");
	}
}
