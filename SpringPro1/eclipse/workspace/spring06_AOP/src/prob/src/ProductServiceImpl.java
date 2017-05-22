package prob.src;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductServiceImpl implements ProductService{
	private Log log = LogFactory.getLog(getClass());
	
	@Override
	public void deleteProduct(String id) {
		System.out.println("deleteProduct() ... Product " + id);
		log.info("deleteProduct()....");
	}

	@Override
	public void updateProduct(String id) {
		System.out.println("updateProduct() ... Product " + id);
		log.info("updateProduct()....");
	}

	@Override
	public void searchProduct(String id) {
		System.out.println("searchProduct() ... Product " + id);
		log.info("searchProduct()....");
	}
}
