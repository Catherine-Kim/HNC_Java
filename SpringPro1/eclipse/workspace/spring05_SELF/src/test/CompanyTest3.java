package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import self3.Company;

public class CompanyTest3 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("self3.xml");
		Company company = (Company) factory.getBean("company");
		System.out.println(company.getAllEmployee());
	}
}
