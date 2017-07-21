package product.service.model;

import java.util.List;

import product.service.vo.MyProduct;

public interface MyProductDAO {
	void insertMyProduct(MyProduct vo) throws Exception;
	List<MyProduct> findByMaker(String maker) throws Exception;
	List<MyProduct> findByProductName(String str) throws Exception;
}
