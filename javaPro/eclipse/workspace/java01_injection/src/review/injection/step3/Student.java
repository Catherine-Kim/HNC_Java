package review.injection.step3;

/*
 * step 3 ::
 * �ش� Ŭ������ �ʵ忡 ���� �����ϴ� ��η�
 * ����� �����ڸ� ����ϵ��� �ϰڴ�.
 */

public class Student {
	int studentNo;
	String name;
	String subject;
	
	public Student(){	}
	
	// ����� ������
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
