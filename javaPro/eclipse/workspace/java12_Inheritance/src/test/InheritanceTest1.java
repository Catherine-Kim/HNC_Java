package test;

import child.Designer;
import child.Engineer;
import child.Manager;
import parent.Employee;
import util.MyDate;

/*
 * 1. Employee 객체를 생성(이 때 인자값 3) .. e
 * 2. Manager 객체를 생성(인자값 4)...m
 * 3. 각각 객체의 정보를 출력
 */

public class InheritanceTest1 {
	public static void main(String[] args) {
		Employee e = new Employee("Woojeong Kim", new MyDate(1994,06,10), 9000);
		Manager m = new Manager("Woojeong Kim", new MyDate(1994,06,10), 9000, "Development");
		Engineer eg = new Engineer("Woojeong Kim", new MyDate(1994,06,10), 9000, "Java, C, Ruby on Rails");
		Designer d = new Designer("Woojeong Kim", new MyDate(1994,06,10), 9000, true);

		
		System.out.println("e : " + e.getDetails());
		System.out.println("m : " + m.getDetails());
		System.out.println("eg : " + eg.getDetails());
		System.out.println("d : " + d.getDetails());
	}
}
