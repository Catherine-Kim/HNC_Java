package hasing.step1;

public class Engine {
	String fuel;
	String brand;
	public Engine(String fuel, String brand) {
		super();
		this.fuel = fuel;
		this.brand = brand;
	}
	
	// �ʵ忡 ���Ե� ������ �޾ƿ��� �޼ҵ�
	public String getEngine(){
		return fuel + "  " + brand;
	}
}
