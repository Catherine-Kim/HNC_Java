package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.aop.pojo3.MemberDAO;

public class Test3 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("pojo3.xml");
		MemberDAO dao = (MemberDAO) factory.getBean("target");
		dao.update();
	}
}
