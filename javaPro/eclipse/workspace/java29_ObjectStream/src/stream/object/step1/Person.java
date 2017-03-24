package stream.object.step1;

import java.io.Serializable;

public class Person implements Serializable{
	// fields
	private String name;
	private int age;
	private String password;
	private String address;
	
	// constructor
	public Person(String name, int age, String password, String address) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	// toString() Overriding
	@Override
	public String toString() {
		return name + " | " + age + " | " + password + " | " + address;
	}
}
