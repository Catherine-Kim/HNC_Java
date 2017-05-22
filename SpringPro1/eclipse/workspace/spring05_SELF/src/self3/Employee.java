package self3;

public class Employee {
	// field
	private String name;
	private int age;
	private String addr;
	
	// constructor
	public Employee(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Employee :: " + name + " | " + age + " | " + addr;
	}
}
