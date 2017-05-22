package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import api3.MessageBean;

public class APIAopTest3 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("api3.xml");
		MessageBean bean = (MessageBean) factory.getBean("proxy");
		bean.sayHello();
	}
}
