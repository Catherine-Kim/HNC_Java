package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import anno.service.BizService;

public class BizTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("biz.xml");
		BizService service = (BizService) factory.getBean("Target");
		service.findMemberId();
		service.register();
	}
}
