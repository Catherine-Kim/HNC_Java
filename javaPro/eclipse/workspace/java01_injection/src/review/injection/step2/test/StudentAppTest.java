package review.injection.step2.test;

import review.injection.step1.Student;

/*
 * step 2 ::
 * �ش� Ŭ������ ��ü ���� ��,
 * �ʵ忡 ���� �����ϴ� ��η� setter()�� ����غ��ڴ�.
 * �� �� ��ü ������ ����Ʈ�� �Ѵ�.
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
