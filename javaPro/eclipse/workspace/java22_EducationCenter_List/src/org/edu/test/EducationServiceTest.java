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
		Student s1 = new Student("111", "김우정", 24, "경상북도", new MyDate(1994, 06, 10), "st3212");
		Student s2 = new Student("222", "박세연", 24, "경기도", new MyDate(1993, 07, 07), "st2450");
		Student s3 = new Student("333", "이알찬", 24, "강원도", new MyDate(1994, 07, 01), "st2881");

		// Teacher(int ssn, String name, int age, String address, MyDate
		// birthday, String subject)
		Teacher t1 = new Teacher("444", "서고은", 24, "경기도", new MyDate(1994, 8, 13), "지리");
		Teacher t2 = new Teacher("555", "이예진", 24, "경상남도", new MyDate(1994, 9, 22), "한자");

		// Employee(int ssn, String name, int age, String address, MyDate
		// birthday, String dept)
		Employee e1 = new Employee("666", "고유진", 24, "서울특별시", new MyDate(1994, 06, 03), "마케팅");

		System.out.println("1. addPerson()");
		try { // pList에 s1 추가
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
		try { // 리스트에 존재하는 사람 삭제
			service.deletePerson("555");
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try { // 리스트에 존재하지 않는 사람 삭제(Exception 발생)
			service.deletePerson("999");
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}

		service.getPersons();

		System.out.println("\n4. findPerson() w/ address");
		ArrayList<Person> people = service.findPerson("경기도");

		service.getPersons(people);

		System.out.println("\n5. updatePerson()");
		try { // 리스트에 존재하는 사람 업데이트
			service.updatePerson(new Student("222", "박세연", 25, "전라북도", new MyDate(1993, 01, 01), "개발"));
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try { // 리스트에 존재하지 않는 사람 업데이트 (Exception 발생)
			service.updatePerson(new Employee("999", "유수빈", 24, "서울특별시", new MyDate(1994, 12, 2), "회계"));
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}

		service.getPersons();
	}
}
