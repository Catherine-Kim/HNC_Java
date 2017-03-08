package review.injection.step4;

/*
 * step 4 ::
 * Student가 Book을 가지는 관계를 설정
 * Book 클래스 먼저 만들어야 함
 * 1) Book의 주입은 setter()로 간다.
 * 2) 학생이 소유한 책을 다시 return 받는 getBook()
 */

public class Student {
	int studentNo;
	String name;
	String subject;
	Book book;
	
	public Student(){	}
	
	// 명시적 생성자
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
