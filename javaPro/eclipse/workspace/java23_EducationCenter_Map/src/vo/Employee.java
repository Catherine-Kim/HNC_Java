package vo;

import util.MyDate;

public class Employee extends Person{
	// fields
	private String dept;
	
	// constructors
	public Employee(){}

	public Employee(String ssn, String name, int age, String address, MyDate birthday, String dept) {
		super(ssn, name, age, address, birthday);
		this.dept = dept ;
	};
	
	public Employee(String name, int age, String address, MyDate birthday, String dept) {
		super(name, age, address, birthday);
		this.dept = dept;
	};
	
	// getters and setters
	public String getDept() {
		return dept ;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}	
	
	// toString Overriding
	@Override
	public String toString() {
		return super.toString() + " [" + dept + "]";
	}
}
