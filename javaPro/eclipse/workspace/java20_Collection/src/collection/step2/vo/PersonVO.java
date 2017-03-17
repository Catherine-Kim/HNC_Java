package collection.step2.vo;

public class PersonVO {
	// fields
	String name;
	int age;
	String address;
	
	// constructors
	public PersonVO(){};
	
	public PersonVO(String name, int age, String address){
		this.name = name;
		this.age = age;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	};
	
	// toString() Overriding
	@Override
	public String toString() {
		return name + "(" + age + ") [" + address + "]";
	}
}
