package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import solve2.src.MemberService;
import solve2.src.ProductService;

public class AOPTestSolve3 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("solve2.xml");
		MemberService mem = factory.getBean("member", MemberService.class);
		ProductService pro = factory.getBean("product", ProductService.class);
		
		mem.register();
		System.out.println("-----------------------------");
		mem.findMemberByID("Friendship");
		System.out.println("-----------------------------");
		
		pro.deleteProduct("aop");
	}
}
