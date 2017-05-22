package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import self.Customer;

public class BankTest1 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("self1.xml");
		Customer customer = (Customer) factory.getBean("cust");
		System.out.println("1) getCustomer() :: \n" + customer.getCustomer());
		System.out.println("2) getBanalce() from Account :: \n" + 
														customer.getAccount().getBalance());
	}
}
