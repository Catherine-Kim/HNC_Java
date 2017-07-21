package product.service.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import product.service.model.MyProductDAO;
import product.service.vo.MyProduct;

public class MyProductDAOImpl implements MyProductDAO{
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		System.out.println(":: " + getClass().getName() + ".setSqlSession() 호출");
		this.sqlSession = sqlSession;
	}

	@Override
	public void insertMyProduct(MyProduct vo) throws Exception {
		System.out.println("insertMyProduct() :: " + 
				sqlSession.insert("productMapper.insertMyProduct", vo) + " ROW INSERTED");
		//sqlSession.commit();
	}

	@Override
	public List<MyProduct> findByMaker(String maker) throws Exception {
		return sqlSession.selectList("productMapper.findByMaker", maker);
	}

	@Override
	public List<MyProduct> findByProductName(String str) throws Exception {
		return sqlSession.selectList("productMapper.findByProductName", str);
	}
}
