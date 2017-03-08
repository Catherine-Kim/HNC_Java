package review.injection.step3;

/*
 * step 3 ::
 * 해당 클래스는 필드에 값을 주입하는 통로로
 * 명시적 생성자를 사용하도록 하겠다.
 */

public class Student {
	int studentNo;
	String name;
	String subject;
	
	public Student(){	}
	
	// 명시적 생성자
	public Student(int studentNo, String name, String subject) {
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.subject = subject;
	}
	
	public String getStudentInfo(){
		return studentNo + " " + name + " " + subject;
	}
	
}
