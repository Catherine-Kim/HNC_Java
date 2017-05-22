package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import prob.src.MemberService;
import prob.src.ProductService;

public class AOPTestProb1 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("prob.xml");
		MemberService mem = (MemberService) factory.getBean("member");
		ProductService pro = (ProductService) factory.getBean("product");
		
		mem.register();
		mem.findMemberByID("spring");
		
		System.out.println("--------------------------------------------");
		
		pro.deleteProduct("di");
		pro.updateProduct("di");
	}
}
