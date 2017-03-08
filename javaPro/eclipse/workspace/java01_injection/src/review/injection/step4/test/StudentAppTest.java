package review.injection.step4.test;

import review.injection.step4.Student;
import review.injection.step4.Book;

/*
 * step 4 ::
 * 학생 객체를 생성(st1, st2)
 * 각각의 학생이 서로 다른 책을 가직 있다는 로직을 작성
 * 콘솔로 학생 정보와 그 학생이 가지고 있는 책 정보를 함께 출력
 */

public class StudentAppTest {
	public static void main(String[] args){
		Book b1 = new Book();
		Book b2 = new Book();
		
		b1.setName("천사와 악마");
		b1.setAuthor("댄브라운");
		
		b2.setName("용의자 X의 헌신");
		b2.setAuthor("히가시노 게이고");
		
		Student st1 = new Student(3214, "Josh", "Economics", b1);
		Student st2 = new Student(3342, "Ollie", "Art", b2);
		
		System.out.println(st1.getStudentInfo());
		System.out.println(st1.getStudentBook());
		System.out.println(st2.getStudentInfo());
		System.out.println(st2.getStudentBook());
	}

}
