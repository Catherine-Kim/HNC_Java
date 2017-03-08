package hasing.step1;

public class Engine {
	String fuel;
	String brand;
	public Engine(String fuel, String brand) {
		super();
		this.fuel = fuel;
		this.brand = brand;
	}
	
	// 필드에 주입된 정보를 받아오는 메소드
	public String getEngine(){
		return fuel + "  " + brand;
	}
}
