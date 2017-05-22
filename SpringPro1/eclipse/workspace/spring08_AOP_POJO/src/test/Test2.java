package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.aop.pojo2.MemberDAO;

public class Test2 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("pojo2.xml");
		MemberDAO dao = (MemberDAO) factory.getBean("target");
		dao.register();
		System.out.println("------------------------------");
		System.out.println(dao.findById("Friendship"));
	}
}
