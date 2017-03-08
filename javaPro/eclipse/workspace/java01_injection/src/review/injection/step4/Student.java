package review.injection.step4;

/*
 * step 4 ::
 * Student�� Book�� ������ ���踦 ����
 * Book Ŭ���� ���� ������ ��
 * 1) Book�� ������ setter()�� ����.
 * 2) �л��� ������ å�� �ٽ� return �޴� getBook()
 */

public class Student {
	int studentNo;
	String name;
	String subject;
	Book book;
	
	public Student(){	}
	
	// ����� ������
	public Student(int studentNo, String name, String subject, Book book) {
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.subject = subject;
		this.book = book;
	}
	
	public String getStudentInfo(){
		return studentNo + " " + name + " " + subject;
	}
	
	public String getStudentBook(){
		return book.name + " " + book.author;
	}
	
}
