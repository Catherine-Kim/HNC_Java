package product.service.model;

import product.service.vo.MyProductVO;

/*
 * 비지니스 로직 이름은
 * ~mapper.xml의 id 이름과 동일하게 작성한다.
 */
public interface MyProductDAO {
	public void insertMyProduct(MyProductVO vo) throws Exception;
	
}














