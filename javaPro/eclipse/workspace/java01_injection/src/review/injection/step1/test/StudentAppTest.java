package review.injection.step1.test;

import review.injection.step1.Student;

/*
 * step1 ::
 * Student Ŭ������ ���� ���ԵǴ� ������ �����ִ� Ŭ����
 * ù��°��, �ʵ忡 ���� ���� �����ϴ� ������ �ۼ�
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
