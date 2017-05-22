package solve2.src;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductServiceImpl implements ProductService{
	
	@Override
	public void deleteProduct(String id) {
		System.out.println("deleteProduct() ... Product " + id);
	}

	@Override
	public void updateProduct(String id) {
		System.out.println("updateProduct() ... Product " + id);
	}

	@Override
	public void searchProduct(String id) {
		System.out.println("searchProduct() ... Product " + id);
	}
}
