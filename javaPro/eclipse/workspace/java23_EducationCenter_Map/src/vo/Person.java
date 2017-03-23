package vo;

import util.MyDate;

public abstract class Person {
	// fields
	private String ssn;			// 타입을 int에서 String으로 변경
	private String name;
	private int age;
	private String address;
	private MyDate birthday;
	
	// constructors
	public Person(){}

	public Person(String ssn, String name, int age, String address, MyDate birthday) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.age = age;
		this.address = address;
		this.birthday = birthday;
	}
	
	public Person(String name, int age, String address, MyDate birthday){
		this.name = name;
		this.age = age;
		this.address = address;
		this.birthday = birthday;
	}

	// getters and setters
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
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
	}

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	};
	
	// toString() Overriding
	@Override
	public String toString() {
		return ssn + " : " + name + "(" + age + ") [" + address + "] [" + birthday + "]";
	}
}
