package test;

import child.Designer;
import child.Engineer;
import child.Manager;
import parent.Employee;
import util.MyDate;

public class InheritanceTest3 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Designer d1 = new Designer("KWJ", new MyDate(1994, 06, 10), 9000, true);
		Designer d2 = new Designer("KAB", new MyDate(1994, 06, 11), 8000, false);
		Engineer e1 = new Engineer("PWR", new MyDate(1994, 06, 12), 7000, "Java");
		Engineer e2 = new Engineer("PSH", new MyDate(1994, 06, 13), 6000, "Python");
		Manager m1 = new Manager("LTH", new MyDate(1994, 06, 12), 5000, "Clothes");
		Manager m2 = new Manager("LYJ", new MyDate(1994, 06, 11), 4000, "Cosmetics");
		
		Employee[] elist = {d1, d2, e1, e2, m1, m2};
		
		for(Employee e : elist){
			if(e instanceof Engineer){
				System.out.println(e.getDetails());
			}
		}
	}
}
