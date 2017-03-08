package test;

import child.Designer;
import child.Engineer;
import child.Manager;
import parent.Employee;
import util.MyDate;

/*
 * 1. Employee ��ü�� ����(�� �� ���ڰ� 3) .. e
 * 2. Manager ��ü�� ����(���ڰ� 4)...m
 * 3. ���� ��ü�� ������ ���
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
