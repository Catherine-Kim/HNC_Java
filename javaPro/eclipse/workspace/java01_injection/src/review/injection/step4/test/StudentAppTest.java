package review.injection.step4.test;

import review.injection.step4.Student;
import review.injection.step4.Book;

/*
 * step 4 ::
 * �л� ��ü�� ����(st1, st2)
 * ������ �л��� ���� �ٸ� å�� ���� �ִٴ� ������ �ۼ�
 * �ַܼ� �л� ������ �� �л��� ������ �ִ� å ������ �Բ� ���
 */

public class StudentAppTest {
	public static void main(String[] args){
		Book b1 = new Book();
		Book b2 = new Book();
		
		b1.setName("õ��� �Ǹ�");
		b1.setAuthor("�����");
		
		b2.setName("������ X�� ���");
		b2.setAuthor("�����ó� ���̰�");
		
		Student st1 = new Student(3214, "Josh", "Economics", b1);
		Student st2 = new Student(3342, "Ollie", "Art", b2);
		
		System.out.println(st1.getStudentInfo());
		System.out.println(st1.getStudentBook());
		System.out.println(st2.getStudentInfo());
		System.out.println(st2.getStudentBook());
	}

}
