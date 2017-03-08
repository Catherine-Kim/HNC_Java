package hasing.step3;

public class Car {
	boolean isAuto;
	char color;
	String model;
	float price;
	
	Engine engine;

	// setter�� ���� �ʵ忡 ���� ����
	public void setCar(boolean isAuto, char color, String model, float price, Engine engine){
		this.isAuto = isAuto;
		this.color = color;
		this.model = model;
		this.price = price;
		this.engine = engine;
	}
	
	// Method Overloading - Engine ���� �� �ִ� setter
	public void setCar(boolean isAuto, char color, String model, float price){
		this.isAuto = isAuto;
		this.color = color;
		this.model = model;
		this.price = price;
	}
	
	// Method Overloading - Engine ���� �ִ� setter
	public void setCar(Engine engine){
		this.engine = engine;
	}
	
	public String getCar(){
		return model + "  " + price + "  " + color + "  " + isAuto;
	}
	
	public Engine getEngine(){
		return engine;
	}
}
