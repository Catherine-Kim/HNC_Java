package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import step2.src.MyService;



public class MyServiceTest2 {
	public static void main(String[] args) {
/*		
		// 1. 설정문서를 읽어들인다.
		Resource r = new FileSystemResource("src/step1/src/msg1.xml");
		System.out.println("[SUCCESS] Read Bean Configuration File");
		
		// 2. DI Container를 생성한다.
		System.out.println("1. DI Container 생성");
		BeanFactory factory = new XmlBeanFactory(r);
		System.out.println("[SUCCESS] Create Bean Factory");
*/		
		// 1. 2. 설정문서 읽으면서 바로 DI Container를 만든다.
		System.out.println("1. DI Container 생성");
		ApplicationContext factory = 
							new FileSystemXmlApplicationContext("src/msg2.xml");
	
		
		// 3. Container에 저장된 Bean을 요청한다.
		System.out.println("2. 'msg1' Bean 요청");
		MyService service1 = (MyService) factory.getBean("msg1");
		System.out.println("[SUCCESS] Get Bean From Factory");
		
		// 4. Bean의 메소드를 호출한다.
		System.out.println("3. Bean의 메소드 호출");
		System.out.println("MyService message :: " + service1.pringMsg());
		System.out.println("MyService details :: " + service1.getDetails());
	}
}
