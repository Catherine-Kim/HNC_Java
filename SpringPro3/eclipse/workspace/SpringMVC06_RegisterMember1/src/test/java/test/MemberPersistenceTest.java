package test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.model.MemberDAO;
import spring.service.model.impl.MemberDAOImpl;

public class MemberPersistenceTest {
	@Test
	public void JUnitTest() throws IOException{
		ApplicationContext factory = new FileSystemXmlApplicationContext("WEB-INF/spring/root-context.xml");
		
		MemberDAO dao = new MemberDAOImpl();
		
		MemberVO vo = new MemberVO("1414", "woojeong", "0000", "LA");
		MemberVO vo1 = new MemberVO("1414", "KIM WOOJEONG", "0000", "Austin");
		
		System.out.println("1. "); 
		dao.registerMember(vo);
		System.out.println("2. " + dao.idcheck("1414"));
		System.out.println("3. " + dao.login(vo));
		System.out.println("4. ");
		dao.updateMember(vo1);
		System.out.println("5. " + dao.findByAddress("London, England"));
		System.out.println("6. " + dao.getAddressKind());
		System.out.println("7. " + dao.getAllMember());
		
	}
}
