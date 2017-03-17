package child;

import parent.Employee;

public class Manager extends Employee{
	// fields
	private String dept;
	
	// constructor
	public Manager(String empId, String name, String address, int salary, String dept) {
		super(empId, name, address, salary);
		this.dept = dept;
	}
	
	// toString() Override
	@Override
	public String toString() {
		return super.toString() + "\t" + dept;
	}
	
	// getter() / setter()

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
}
