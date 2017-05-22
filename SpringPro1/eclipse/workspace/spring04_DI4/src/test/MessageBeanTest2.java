package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample2.MessageBean;

public class MessageBeanTest2 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("messageBean2.xml");
		
		MessageBean message = (MessageBean) factory.getBean("message");
		message.sayMessage();
	}
}
