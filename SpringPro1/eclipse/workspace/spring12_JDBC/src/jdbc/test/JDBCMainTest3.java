package jdbc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jdbc3.MemberDAO;
import jdbc3.MemberVO;

public class JDBCMainTest3 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("jdbc3/jdbc.xml");
		MemberDAO dao = (MemberDAO) factory.getBean("memberDao");
		
		// ������ HTML form�� ���� ���� �޾ƾ� ������ ������ form�� ���� �� �����Ƿ� ���⼭ ���� �Է�
		MemberVO vo = new MemberVO();
		vo.setId("kosta");
		vo.setPassword("1234");
		vo.setName("�ڽ�Ÿ");
		vo.setAddress("������");
		
		//dao.getMemberList();
		/*dao.register(vo);
		System.out.println("[SUCCESS] register() from JDBCMainTest1");*/
		//System.out.println(dao.getMemberList());
		System.out.println(dao.getSearch("kosta"));
	}
}
