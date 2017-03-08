package hasing.step2;

public class Car {
	boolean isAuto;
	char color;
	String model;
	float price;
	
	Engine engine;

	// Test Ŭ�������� ���ڰ��� �־��� ��,
	// ���ڰ��� ����, ����, Ÿ���� �� ���Ѽ� �־����
	public Car(boolean isAuto, char color, String model, float price, Engine engine) {
		super();
		this.isAuto = isAuto;
		this.color = color;
		this.model = model;
		this.price = price;
		this.engine = engine;
	}
	
	// �̰��� Overloading : Overloading�� arguement resource�� �޶����(����, ���� ��)
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
