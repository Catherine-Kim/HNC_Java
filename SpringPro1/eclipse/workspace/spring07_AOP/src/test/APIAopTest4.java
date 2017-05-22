package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import api4.MessageBean;

public class APIAopTest4 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("api4.xml");
		MessageBean bean = (MessageBean) factory.getBean("target");
		bean.sayHello();
	}
}
