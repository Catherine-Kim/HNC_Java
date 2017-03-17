package test;

import child.Designer;
import child.Engineer;
import child.Manager;
import parent.Employee;

public class PolymorphicTest1 {
	public static void main(String[] args) {
		Employee e1 = new Manager("m32", "Woojeong Kim", "경상북도 울진군", 9000, "Part A");
		Employee e2 = new Engineer("e07", "Jimin Park", "경상남도 진주시", 8000, "Java", 3000);
		Employee e3 = new Designer("e07", "Jimin Park", "경상남도 진주시", 8000, true);
		
		System.out.println("1. Virtual Method Invocation :: ");
		System.out.println(e1);
		System.out.println(e2);
		
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		
		System.out.println("\n2. Object Casting");
		((Manager)e1).setDept("Part Z");
		System.out.println(e1.toString());
	}
}
