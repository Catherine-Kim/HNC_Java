package test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import spring.service.domain.MemberVO;

public class MemberMyBatisTest {
	@Test
	public void JUnitTest() throws IOException{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		MemberVO vo = new MemberVO("1313", "woojeong", "0000", "LA");
		MemberVO vo1 = new MemberVO("1313", "KIM WOOJEONG", "0000", "Austin");
		
		/*sqlSession.insert("memberMapper.registerMember", vo);
		session.commit();
		System.out.println(session.selectOne("memberMapper.idcheck", "1313"));*/
		
		/*System.out.println(session.selectOne("memberMapper.login", vo));
		session.update("memberMapper.updateMember", vo1);
		session.commit();*/
		
		System.out.println("1. fba");
		System.out.println(session.selectList("memberMapper.findByAddress", "London, England"));
		System.out.println("2. gak");
		System.out.println(session.selectList("memberMapper.getAddressKind"));
		System.out.println("3. gam");
		System.out.println(session.selectList("memberMapper.getAllMember"));
	}
}
