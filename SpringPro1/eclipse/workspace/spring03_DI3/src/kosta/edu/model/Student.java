package kosta.edu.model;

public class Student {
	int studentId;
	String name;
	
	public Student(int studentId, String name) {
		super();
		this.studentId = studentId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + "]";
	}
}
