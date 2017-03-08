package overloading.constructor.step4.test;

class Car{
	private String color;
	private String geerType;
	private int door;
	
	public Car(){
		this("Black", "Stick", 4);
	};
	
	public Car(String color, String geerType, int door){
		this.color = color;
		this.geerType = geerType;
		this.door = door;
	}
	
	public Car(String color){
		this(color, "Stick", 4);
	}
	
	public String getCarInfo(){
		return color + " | " + geerType + " | " + door;
	}
}
public class CarConstructorTest4 {
	public static void main(String[] args) {
		System.out.println("car1 creating...");
		Car car1 = new Car();
		System.out.println(car1.getCarInfo());
		
		System.out.println("car2 creating...");
		Car car2 = new Car("white");
		System.out.println(car2.getCarInfo());
		
		System.out.println("car3 creating...");
		Car car3 = new Car("white", "Auto", 4);
		System.out.println(car3.getCarInfo());
	}
}
