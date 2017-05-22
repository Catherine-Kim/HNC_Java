package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import step3.src.UserDAO;

public class UserDAOUsingSpringTest3 {
	public static void main(String[] args) {
		// 1. ���������� ���� ���� �о�鿩�� ��
		Resource r = new FileSystemResource("src/step3/src/bean.xml");
		System.out.println("[SUCCESS] Read Bean Configuration File");
		
		// 2. Bean�� �����ϴ� Factory ����
		BeanFactory factory = new XmlBeanFactory(r);
		System.out.println("[SUCCESS] Create Bean Factory");
		
		// 3. Factory�� ���� Bean ��������
		UserDAO user1 = (UserDAO) factory.getBean("daoKr");
		UserDAO user2 = factory.getBean("daoEn", UserDAO.class);
		System.out.println("[SUCCESS] Get Beans From Factory");
		
		// 4. Bean�� �޼ҵ� ȣ��
		user1.sayHelloMemeber("���õ� ���� �Ϸ� :)");
		user2.sayHelloMemeber("Everything will be alright :D");
	}
}
