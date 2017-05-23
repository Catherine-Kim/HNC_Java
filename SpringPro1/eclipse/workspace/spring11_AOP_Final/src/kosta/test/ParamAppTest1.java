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
		
		customer.register("", "�ں���");		// ù ��° ���� �ȵ� ���
		customer.insertCustomer("������");	// �� ����� �� ���
		System.out.println("---------------------------");
		member.deleteMember(null, "");		// ���� �� �� �� ���
	}
}















