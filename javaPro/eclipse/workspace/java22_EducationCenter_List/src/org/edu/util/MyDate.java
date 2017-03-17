package org.edu.util;

public class MyDate {
	// fields
	private int year;
	private int month;
	private int day;
	
	// constructors
	public MyDate(){}

	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	// getters and setters
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	};
	
	// toString() Overriding
	@Override
	public String toString() {
		return year + "/" + month + "/" + day;
	}
}
