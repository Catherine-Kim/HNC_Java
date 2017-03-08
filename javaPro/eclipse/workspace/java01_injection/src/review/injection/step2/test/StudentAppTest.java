package review.injection.step2.test;

import review.injection.step1.Student;

/*
 * step 2 ::
 * 해당 클래스는 객체 생성 후,
 * 필드에 값을 주입하는 통로롤 setter()를 사용해보겠다.
 * 이 때 객체 생성은 디폴트로 한다.
 */

public class StudentAppTest {
	public static void main(String[] args){
		Student st1 = new Student();
		Student st2 = new Student();
		
		st1.setName("Josh");
		st1.setStudentNo(3214);
		st1.setSubject("Economics");
		
		st2.setName("Ollie");
		st2.setStudentNo(3342);
		st2.setSubject("Art");
	}

}
