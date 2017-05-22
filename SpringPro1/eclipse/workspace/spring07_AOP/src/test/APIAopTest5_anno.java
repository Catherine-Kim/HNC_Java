package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import api5_anno.MessageBean;

public class APIAopTest5_anno {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("api5_anno.xml");
		MessageBean bean = (MessageBean) factory.getBean("target");
		bean.sayHello();
	}
}
