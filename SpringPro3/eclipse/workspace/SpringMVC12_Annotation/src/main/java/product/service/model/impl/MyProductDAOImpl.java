package product.service.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product.service.model.MyProductDAO;
import product.service.vo.MyProductVO;

@Repository
public class MyProductDAOImpl implements MyProductDAO{
	// field
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertMyProduct(MyProductVO vo) throws Exception {
		sqlSession.insert("productMapper.insertMyProduct", vo);
	}
}
