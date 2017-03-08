package review.injection.step3.test;

import review.injection.step3.Student;

/*
 * step 3 ::
 * 해당 클래스는 명시적 생성자를 통해서
 * 필드에 값을 주입하는 로직
 */

public class StudentAppTest {
	public static void main(String[] args){
		Student st1 = new Student(3214, "Josh", "Economics");
		Student st2 = new Student(3342, "Ollie", "Art");
	}

}
