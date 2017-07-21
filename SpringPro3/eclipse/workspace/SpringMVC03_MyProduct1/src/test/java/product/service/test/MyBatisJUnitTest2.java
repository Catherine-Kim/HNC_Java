package product.service.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import product.service.vo.MyProduct;

public class MyBatisJUnitTest2 {
	@Test
	public void jTest() throws IOException {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		MyProduct vo = new MyProduct("통돌이 세탁기", "대우", 120);
		System.out.println(session.insert("productMapper.insertMyProduct", vo) + "ROW INSERTED");
		session.commit();
		
		/*List<MyProduct> list = session.selectList("productMapper.findByProductName", "세탁");
		for(MyProduct p : list){
			System.out.println(p);
		}*/
	}
}
