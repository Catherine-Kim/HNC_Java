package org.edu.vo;

import org.edu.util.MyDate;

public class Student extends Person{
	// fields
	private String stuID;
	
	// constructors
	public Student(){}

	public Student(String ssn, String name, int age, String address, MyDate birthday, String stuID) {
		super(ssn, name, age, address, birthday);
		this.stuID = stuID;
	};
	
	public Student(String name, int age, String address, MyDate birthday, String stuID) {
		super(name, age, address, birthday);
		this.stuID = stuID;
	};
	
	// getters and setters
	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}	
	
	// toString Overriding
	@Override
	public String toString() {
		return super.toString() + " [" + stuID + "]";
	}
}
