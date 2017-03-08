package team.step1.marketVO;

public class CustomerVO {
	// Fields
	private String name;
	private ProductVO[] productList;
	private int expense;
	
	// Constructors
	public CustomerVO(){};
	
	public CustomerVO(String name, ProductVO[] productList, int expense){
		this.name = name;
		this.productList = productList;
		this.expense = expense;
	}
	
	// Getters
	public String getName(){
		return this.name;
	}
	
	public ProductVO[] getProductList(){
		return this.productList;
	}
	
	public int getExpense(){
		return this.expense;
	}

	// Setters
	public void setName(String name){
		this.name = name;
	}
	
	public void setProductList(ProductVO[] productList){
		this.productList = productList;
	}
	
	public void setExpense(int expense){
		this.expense = expense;
	}
}




