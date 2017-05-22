package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import step1.src.MyService;

public class MyServiceTest1 {
	public static void main(String[] args) {
/*		
		// 1. ���������� �о���δ�.
		Resource r = new FileSystemResource("src/step1/src/msg1.xml");
		System.out.println("[SUCCESS] Read Bean Configuration File");
		
		// 2. DI Container�� �����Ѵ�.
		System.out.println("1. DI Container ����");
		BeanFactory factory = new XmlBeanFactory(r);
		System.out.println("[SUCCESS] Create Bean Factory");
*/		
		// 1. 2. �������� �����鼭 �ٷ� DI Container�� �����.
		System.out.println("1. DI Container ����");
		ApplicationContext factory = 
							new FileSystemXmlApplicationContext("src/step1/src/msg1.xml");
	
		
		// 3. Container�� ����� Bean�� ��û�Ѵ�.
		System.out.println("2. 'msg1' Bean ��û");
		MyService service1 = (MyService) factory.getBean("msg1");
		System.out.println("[SUCCESS] Get Bean From Factory");
		
		// 4. Bean�� �޼ҵ带 ȣ���Ѵ�.
		System.out.println("3. Bean�� �޼ҵ� ȣ��");
		System.out.println("MyService message :: " + service1.pringMsg());
	}
}
