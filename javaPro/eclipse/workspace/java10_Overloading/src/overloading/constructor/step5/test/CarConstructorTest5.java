package overloading.constructor.step5.test;

class Car{
	private String color;
	private String geerType;
	private int door;
	
	public static final String BASIC_COLOR = "Black";
	public static final String DEFAULT_GEER_TYPE = "Stick";
	public static final int DEFAULT_DOOR = 4;
	
	public Car(){
		this(BASIC_COLOR, DEFAULT_GEER_TYPE, DEFAULT_DOOR);
	};
	
	public Car(String color, String geerType, int door){
		this.color = color;
		this.geerType = geerType;
		this.door = door;
	}
	
	public Car(String color){
		this(color, DEFAULT_GEER_TYPE, DEFAULT_DOOR);
	}
	
	public String getCarInfo(){
		return color + " | " + geerType + " | " + door;
	}
}
public class CarConstructorTest5 {
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
