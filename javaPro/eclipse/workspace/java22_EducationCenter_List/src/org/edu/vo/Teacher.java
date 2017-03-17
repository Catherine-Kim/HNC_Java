package org.edu.vo;

import org.edu.util.MyDate;

public class Teacher extends Person{
	// fields
	private String subject;
	
	// constructors
	public Teacher(){}

	public Teacher(String ssn, String name, int age, String address, MyDate birthday, String subject) {
		super(ssn, name, age, address, birthday);
		this.subject = subject ;
	};
	
	public Teacher(String name, int age, String address, MyDate birthday, String subject) {
		super(name, age, address, birthday);
		this.subject = subject;
	};
	
	// getters and setters
	public String getSubject() {
		return subject ;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}	
	
	// toString Overriding
	@Override
	public String toString() {
		return super.toString() + " [" + subject + "]";
	}
}
