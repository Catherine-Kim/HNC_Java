package team.step1.marketVO;

public class ProductVO {
	// Fields
	private String brand;
	private int price;
	private int count;
	
	// Constructors
	public ProductVO(){};
	
	public ProductVO(String brand, int price, int count){
		this.brand = brand;
		this.price = price;
		this.count = count;
	}
	
	// Getters
	public String getBrand(){
		return this.brand;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public int getCount(){
		return this.count;
	}

	// Setters
	public void setBrand(String brand){
		this.brand = brand;
	}
	
	public void setPrice(int price){
		this.price = price;
	}
	
	public void setCount(int count){
		this.count = count;
	}
}

