package parent;

public class Employee {
	// fields
	private String empId;
	private String name;
	private String address;
	private int salary;
	
	// constructors
	public Employee(){};
	
	public Employee(String empId, String name, String address, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return empId + "\t" + name + "\t" + address + "\t" + salary;
	}

	// setter() and getter()
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}
