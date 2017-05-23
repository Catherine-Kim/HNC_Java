package jdbc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jdbc.MemberDAO;
import jdbc.MemberVO;

public class JDBCMainTest1 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("jdbc/jdbc.xml");
		MemberDAO dao = (MemberDAO) factory.getBean("memberDao");
		
		// 원래는 HTML form을 통해 값을 받아야 하지만 지금은 form을 만을 수 없으므로 여기서 직접 입력
		MemberVO vo = new MemberVO();
		vo.setId("kosta");
		vo.setPassword("1234");
		vo.setName("코스타");
		vo.setAddress("죽전동");
		
		//dao.getMemberList();
		/*dao.register(vo);
		System.out.println("[SUCCESS] register() from JDBCMainTest1");*/
		System.out.println(dao.getMemberList());
		//System.out.println(dao.getSearch("kosta"));
	}
}
