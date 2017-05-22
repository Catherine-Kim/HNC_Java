package api;

import org.springframework.aop.framework.ProxyFactoryBean;

public class APIAopTest1 {
	public static void main(String[] args) {
		// 1. Target, Advice, Factory ����
		MessageImpl target = new MessageImpl();
		MessageAdvice advice = new MessageAdvice();
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		
		// 2. Factory�� Target�� Advice �߰�
		pfBean.setTarget(target);
		pfBean.addAdvice(advice);
		
		// 3. Factory���� Target�� �޾ƿ�
		Message pfTarget = (Message) pfBean.getObject();
		
		// 4. Factory�� Business Logic�� ȣ�� -> Advice�� Method�� Weaving��
		System.out.println("pfTarget�� Business Logic ȣ�� ::");
		pfTarget.print();
		pfTarget.message();
		
		System.out.println("----------------------------------------------");
		System.out.println("�׳� target�� Business Logic ȣ�� ::");
		target.print();
		target.message();
	}
}
