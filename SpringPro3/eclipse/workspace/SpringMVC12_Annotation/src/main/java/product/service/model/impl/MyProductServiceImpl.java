package product.service.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.service.model.MyProductDAO;
import product.service.model.MyProductService;
import product.service.vo.MyProductVO;

@Service
public class MyProductServiceImpl implements MyProductService{
	// field 
	@Autowired
	private MyProductDAO myProductDAO;

	@Override
	public void insertMyProduct(MyProductVO vo) throws Exception {
		myProductDAO.insertMyProduct(vo);		
	}
}
