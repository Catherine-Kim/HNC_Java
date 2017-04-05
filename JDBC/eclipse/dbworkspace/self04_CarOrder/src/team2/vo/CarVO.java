package team2.vo;

public class CarVO {
	// fields
	private String model;
	private String color;
	private int price;
	private String brand;
	
	// constructors
	public CarVO(){};
	
	public CarVO(String model, String color, int price, String brand) {
		super();
		this.model = model;
		this.color = color;
		this.price = price;
		this.brand = brand;
	}

	// getters and setters
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return model + "\t" + color + "\t" + price + "\t" + brand;
	}	
}
