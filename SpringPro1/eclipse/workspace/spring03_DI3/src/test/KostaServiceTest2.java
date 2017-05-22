package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import kosta.edu.model.KostaServiceImpl;

public class KostaServiceTest2 {
	public static void main(String[] args) {
		ApplicationContext factory = new FileSystemXmlApplicationContext("src/bean2.xml");
		KostaServiceImpl msg2 = (KostaServiceImpl) factory.getBean("msg2");
		System.out.println(msg2.message());
	}
}
