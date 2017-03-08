package hasing.step2;

public class Car {
	boolean isAuto;
	char color;
	String model;
	float price;
	
	Engine engine;

	// Test 클래스에서 인자값을 넣어줄 때,
	// 인자값의 순서, 개수, 타입을 잘 지켜서 넣어야함
	public Car(boolean isAuto, char color, String model, float price, Engine engine) {
		super();
		this.isAuto = isAuto;
		this.color = color;
		this.model = model;
		this.price = price;
		this.engine = engine;
	}
	
	// 이것이 Overloading : Overloading은 arguement resource가 달라야함(순서, 개수 등)
	public Car(boolean isAuto, char color, String model, float price) {
		super();
		this.isAuto = isAuto;
		this.color = color;
		this.model = model;
		this.price = price;
	}
	
	public String getCar(){
		return model + "  " + price + "  " + color + "  " + isAuto;
	}
	
	public Engine getEngine(){
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	
}
