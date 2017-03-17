package org.edu.test;

import java.util.ArrayList;

import org.edu.exception.DuplicateSSNException;
import org.edu.exception.RecordNotFoundException;
import org.edu.service.EducationService;
import org.edu.util.MyDate;
import org.edu.vo.Employee;
import org.edu.vo.Person;
import org.edu.vo.Student;
import org.edu.vo.Teacher;

public class EducationServiceTest {
	public static void main(String[] args) {
		EducationService service = new EducationService(10);

		// Student(int ssn, String name, int age, String address, MyDate
		// birthday, int stuID)
		Student s1 = new Student("111", "�����", 24, "���ϵ�", new MyDate(1994, 06, 10), "st3212");
		Student s2 = new Student("222", "�ڼ���", 24, "��⵵", new MyDate(1993, 07, 07), "st2450");
		Student s3 = new Student("333", "�̾���", 24, "������", new MyDate(1994, 07, 01), "st2881");

		// Teacher(int ssn, String name, int age, String address, MyDate
		// birthday, String subject)
		Teacher t1 = new Teacher("444", "������", 24, "��⵵", new MyDate(1994, 8, 13), "����");
		Teacher t2 = new Teacher("555", "�̿���", 24, "��󳲵�", new MyDate(1994, 9, 22), "����");

		// Employee(int ssn, String name, int age, String address, MyDate
		// birthday, String dept)
		Employee e1 = new Employee("666", "������", 24, "����Ư����", new MyDate(1994, 06, 03), "������");

		System.out.println("1. addPerson()");
		try { // pList�� s1 �߰�
			service.addPerson(s1);
			service.addPerson(s2);
			service.addPerson(s3);
			service.addPerson(t1);
			service.addPerson(t2);
			service.addPerson(e1);
			service.addPerson(s1);
		} catch (DuplicateSSNException | NullPointerException e) {
			System.out.println(e.getMessage());
		}

		service.getPersons();

		System.out.println("\n2. deletePerson()");
		try { // ����Ʈ�� �����ϴ� ��� ����
			service.deletePerson("555");
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try { // ����Ʈ�� �������� �ʴ� ��� ����(Exception �߻�)
			service.deletePerson("999");
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}

		service.getPersons();

		System.out.println("\n4. findPerson() w/ address");
		ArrayList<Person> people = service.findPerson("��⵵");

		service.getPersons(people);

		System.out.println("\n5. updatePerson()");
		try { // ����Ʈ�� �����ϴ� ��� ������Ʈ
			service.updatePerson(new Student("222", "�ڼ���", 25, "����ϵ�", new MyDate(1993, 01, 01), "����"));
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try { // ����Ʈ�� �������� �ʴ� ��� ������Ʈ (Exception �߻�)
			service.updatePerson(new Employee("999", "������", 24, "����Ư����", new MyDate(1994, 12, 2), "ȸ��"));
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}

		service.getPersons();
	}
}
