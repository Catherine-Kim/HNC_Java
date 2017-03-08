package review.injection.step1.test;

import review.injection.step1.Student;

/*
 * step1 ::
 * Student 클래스에 값이 주입되는 과정을 보여주는 클래스
 * 첫번째로, 필드에 값을 직접 주입하는 과정을 작성
 */

public class StudentAppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student st = new Student();
		
		st.setName("Woojeong Kim");
		st.setStudentNo(32122616);
		st.setSubject("Mobile Systems Engineering");
		
		System.out.println("Your name is " + st.getName());
		System.out.println("Your student number is " + st.getStudentNo());
		System.out.println("Your subject is " + st.getSubject());
	}

}
