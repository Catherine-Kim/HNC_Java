package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import kosta.edu.model.KostaServiceImpl;

public class KostaServiceTest3 {
	public static void main(String[] args) {
		ApplicationContext factory = new FileSystemXmlApplicationContext("src/bean3.xml");
		KostaServiceImpl msg3 = (KostaServiceImpl) factory.getBean("msg3");
		System.out.println(msg3.message());
	}
}
