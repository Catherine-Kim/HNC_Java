package stream.object.step3.test;

import java.util.ArrayList;

import stream.object.step3.Car;
import stream.object.step3.CarSerializationService;

public class CarSerialServiceTest{
	public static void main(String[] args)  throws Exception{
		// Variables
		String path = "c:\\kostaObj\\serial\\lis.obj";
		
		Car c1 = new Car("Hyundai", 3000, "black");
		Car c2 = new Car("Porsche", 4000, "red");
		Car c3 = new Car("Maybach", 5000, "black");
		
		ArrayList<Car> list = new ArrayList<Car>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		
		// create CarSerializationService
		CarSerializationService service = new CarSerializationService();
		
		// serialization
		service.outputCar(path, list);
		System.out.println("Serialization done.");
		
		// deserialization
		System.out.println("\nAfter Deserialization : " + service.inputCar(path));
		
	}
}
