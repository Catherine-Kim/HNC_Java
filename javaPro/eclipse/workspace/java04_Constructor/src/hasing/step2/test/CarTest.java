package hasing.step2.test;

import hasing.step2.Car;
import hasing.step2.Engine;

/*
 * Car와 Engine의 관계 : Hasing 관계
 *    - Car가 Engine을 소유하는 관계
 *    - 이렇게 되면 Car의 getXxx()를 통해서 Engine 객체를 받아올 수 있고,
 *      결과적으로 Engine의 모든 성질을 사용하게 된다.
 * 
 * 1. Car 객체를 2개 생성 (car1, car2)
 * 2. Car의 정보를 출력
 *    1) Car의 isAuto, color, price, model
 *    2) Car의 Engine 정보
 */

public class CarTest {

	public static void main(String[] args) {
		Car car1 = new Car(true, 'B', "Audi", 20000, new Engine("petrol", "AAA"));
		Car car2 = new Car(false, 'R', "Lamborghini", 30000);
		// car2는 Engine 없이 만들어졌으니 생성 후에 Engine 주입할거야
		
		car2.setEngine(new Engine("diesel", "BBB"));
		
		System.out.println("'car1' Information :");
		System.out.println("\tCar Info : " + car1.getCar());		
		System.out.println("\tEngine Info : " + car1.getEngine().getEngine());
		System.out.println("\n");
		System.out.println("'car2' Information :");
		System.out.println("\tCar Info : " + car2.getCar());
		System.out.println("\tEngine Info : " + car2.getEngine().getEngine());
	}
}
