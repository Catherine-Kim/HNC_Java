package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.aop.pojo1.MemberDAO;

public class Test1 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("pojo1.xml");
		MemberDAO dao = (MemberDAO) factory.getBean("target");
		dao.register();
	}
}
