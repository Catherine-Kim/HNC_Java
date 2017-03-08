package hasing.step1;

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
	
	public String getCar(){
		return model + "  " + price + "  " + color + "  " + isAuto;
	}
	
	public Engine getEngine(){
		return engine;
	}
}
