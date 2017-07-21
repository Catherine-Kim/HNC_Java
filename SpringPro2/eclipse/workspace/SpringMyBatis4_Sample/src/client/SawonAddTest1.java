package client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.MySawonVO;

public class SawonAddTest1 {
	public static void main(String[] args){
		// vo 생성
		MySawonVO vo = new MySawonVO();
		vo.setId("Friend");
		vo.setName("ship");
		vo.setPwd("1234");
		vo.setAge(20);
		
		// MyBatis Framework를 이용하여 DB에 VO를 insert 해보자
		try{
			// 1. 설정문서(sqlMapConfig.xml) 읽어들이기
			Reader r = Resources.getResourceAsReader("config/sqlMapConfig.xml");
			
			// 2. SqlSessionFactory 얻어내기
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			
			// 3. SqlSession 리턴받기
			SqlSession session = factory.openSession();
			
			// 4. 쿼리문 수행 - insert(), delete(), update(), selectList(), selectOne()
			List<MySawonVO> list = session.selectList("sawonMapper.selectAllSawon");
			int index = 1;
			for(MySawonVO m : list){
				System.out.println("SAWON " + index + " :: " + m.getId() + "(" + m.getName() + ")");
				index++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
