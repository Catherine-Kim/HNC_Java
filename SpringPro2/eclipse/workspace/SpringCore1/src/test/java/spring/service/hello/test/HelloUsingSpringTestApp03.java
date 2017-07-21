package spring.service.hello.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.hello.Hello;

public class HelloUsingSpringTestApp03 {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("config/bean.xml");
		// Class로 인식하니까 src 부분 생략
		
		Hello hello = factory.getBean("hello", Hello.class);
		hello.printMessage();
	}
}
