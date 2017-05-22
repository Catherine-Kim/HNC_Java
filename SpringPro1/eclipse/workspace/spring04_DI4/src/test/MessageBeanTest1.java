package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import sample.MessageBean;

public class MessageBeanTest1 {
	public static void main(String[] args) {
/*		
 		ApplicationContext factory = 
								new FileSystemXmlApplicationContext("src/messageBean1.xml");
*/		
		ApplicationContext factory = new ClassPathXmlApplicationContext("messageBean1.xml");
		
		MessageBean message = (MessageBean) factory.getBean("message");
		message.sayMessage();
	}
}
