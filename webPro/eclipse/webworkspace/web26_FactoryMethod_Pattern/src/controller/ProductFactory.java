package controller;

public class ProductFactory implements Factory{
	// singleton pattern
	private static ProductFactory factory = new ProductFactory();
	private ProductFactory(){};
	public static ProductFactory getInstance(){
		return factory;
	}
	
	@Override
	public Product createProduct(String command) {
		Product product = null;
		if(command.equals("findModel")){
			product = new NoteBookProduct();
		}else if(command.equals("findITV")){
			product = new ITVProduct();
		}
		
		return product;
	}
}
