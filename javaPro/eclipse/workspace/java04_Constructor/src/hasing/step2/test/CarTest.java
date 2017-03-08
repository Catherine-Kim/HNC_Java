package hasing.step2.test;

import hasing.step2.Car;
import hasing.step2.Engine;

/*
 * Car�� Engine�� ���� : Hasing ����
 *    - Car�� Engine�� �����ϴ� ����
 *    - �̷��� �Ǹ� Car�� getXxx()�� ���ؼ� Engine ��ü�� �޾ƿ� �� �ְ�,
 *      ��������� Engine�� ��� ������ ����ϰ� �ȴ�.
 * 
 * 1. Car ��ü�� 2�� ���� (car1, car2)
 * 2. Car�� ������ ���
 *    1) Car�� isAuto, color, price, model
 *    2) Car�� Engine ����
 */

public class CarTest {

	public static void main(String[] args) {
		Car car1 = new Car(true, 'B', "Audi", 20000, new Engine("petrol", "AAA"));
		Car car2 = new Car(false, 'R', "Lamborghini", 30000);
		// car2�� Engine ���� ����������� ���� �Ŀ� Engine �����Ұž�
		
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
