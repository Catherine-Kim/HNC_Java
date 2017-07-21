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
		// vo ����
		MySawonVO vo = new MySawonVO();
		vo.setId("Friend");
		vo.setName("ship");
		vo.setPwd("1234");
		vo.setAge(20);
		
		// MyBatis Framework�� �̿��Ͽ� DB�� VO�� insert �غ���
		try{
			// 1. ��������(sqlMapConfig.xml) �о���̱�
			Reader r = Resources.getResourceAsReader("config/sqlMapConfig.xml");
			
			// 2. SqlSessionFactory ����
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			
			// 3. SqlSession ���Ϲޱ�
			SqlSession session = factory.openSession();
			
			// 4. ������ ���� - insert(), delete(), update(), selectList(), selectOne()
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
