package collection.step2.vo;

public class CustomerVO {
	// fields
	private String name;
	private int age;
	private int custId;
	
	// constructors
	public CustomerVO(){};
	
	public CustomerVO(String name, int age, int custId){
		this.name = name;
		this.custId = custId;
		this.age = age;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	// toString() Overriding
	@Override
	public String toString() {
		return "[" + custId + "] " + name + "(" + age + ")";
	}
}
