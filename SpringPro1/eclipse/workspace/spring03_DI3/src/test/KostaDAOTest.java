package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import kosta.edu.model.KostaDAO;

public class KostaDAOTest {
	public static void main(String[] args) {
		ApplicationContext factory = new FileSystemXmlApplicationContext("src/bean.xml");
		System.out.println("[SUCCESS] Read Conf. File, Create Beans, Inject values");
		// pre-loading
		
		KostaDAO kosta = (KostaDAO) factory.getBean("kosta");
		System.out.println("[SUCCESS] Get Beans From Factory");
		
		System.out.println(kosta);
		kosta.register();
		System.out.println(kosta.pringMsg());
	}
}
