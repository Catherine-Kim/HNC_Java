package product.service.model.impl;

import java.util.List;

import product.service.model.MyProductDAO;
import product.service.model.MyProductService;
import product.service.vo.MyProduct;

public class MyProductServiceImpl implements MyProductService{
	private MyProductDAO myProductDAO;

	public void setMyProductDAO(MyProductDAO myProductDAO) {
		this.myProductDAO = myProductDAO;
	}

	@Override
	public void insertMyProduct(MyProduct vo) throws Exception {
		myProductDAO.insertMyProduct(vo);		
	}

	@Override
	public List<MyProduct> findByMaker(String maker) throws Exception {
		return myProductDAO.findByMaker(maker);
	}

	@Override
	public List<MyProduct> findByProductName(String str) throws Exception {
		return myProductDAO.findByProductName(str);
	}
}
