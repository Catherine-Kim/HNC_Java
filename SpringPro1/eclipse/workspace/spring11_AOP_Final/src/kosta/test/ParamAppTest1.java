package kosta.test;

import kosta.model.Customer;
import kosta.model.Member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ParamAppTest1 {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("param.xml");
		Customer customer = factory.getBean("customer",Customer.class);
		Member member = factory.getBean("member",Member.class);
		
		customer.register("", "박보영");		// 첫 번째 값만 안들어간 경우
		customer.insertCustomer("우정이");	// 값 제대로 들어간 경우
		System.out.println("---------------------------");
		member.deleteMember(null, "");		// 값이 다 안 들어간 경우
	}
}















