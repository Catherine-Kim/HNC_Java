package test;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import self2.Account;
import self2.Customer;

public class BankTest2 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("self2.xml");
		Customer customer = (Customer) factory.getBean("cust");
		System.out.println("1) getCustomer() :: \n" + customer.getCustomer());
		System.out.println("2) Customer's Accounts ::");
		ArrayList<Account> list = customer.getAccount();
		System.out.println(list);
	}
}
