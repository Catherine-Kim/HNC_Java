package parent;

import util.MyDate;

public class Employee {
	private String name;
	private MyDate birthday;
	private double salary;
	
	public Employee(String name, MyDate birthday, double salary) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
	}
	
	public String getDetails(){
		return name + " " + birthday + " " + salary;
	}	
}
