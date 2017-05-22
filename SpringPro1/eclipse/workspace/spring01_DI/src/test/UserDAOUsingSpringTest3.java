package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import step3.src.UserDAO;

public class UserDAOUsingSpringTest3 {
	public static void main(String[] args) {
		// 1. 설정문서를 제일 먼저 읽어들여야 함
		Resource r = new FileSystemResource("src/step3/src/bean.xml");
		System.out.println("[SUCCESS] Read Bean Configuration File");
		
		// 2. Bean을 생성하는 Factory 생성
		BeanFactory factory = new XmlBeanFactory(r);
		System.out.println("[SUCCESS] Create Bean Factory");
		
		// 3. Factory가 만든 Bean 가져오기
		UserDAO user1 = (UserDAO) factory.getBean("daoKr");
		UserDAO user2 = factory.getBean("daoEn", UserDAO.class);
		System.out.println("[SUCCESS] Get Beans From Factory");
		
		// 4. Bean의 메소드 호출
		user1.sayHelloMemeber("오늘도 좋은 하루 :)");
		user2.sayHelloMemeber("Everything will be alright :D");
	}
}
