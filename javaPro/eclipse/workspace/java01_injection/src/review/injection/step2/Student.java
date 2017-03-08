package review.injection.step2;

public class Student {
	int studentNo;
	String name;
	String subject;
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getStudentInfo(){
		return studentNo + " " + name + " " + subject;
	}
	
}
