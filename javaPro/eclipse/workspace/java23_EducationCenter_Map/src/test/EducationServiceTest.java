package test;

import java.util.ArrayList;

import exception.DuplicateSSNException;
import exception.RecordNotFoundException;
import service.EducationService;
import util.MyDate;
import vo.Employee;
import vo.Person;
import vo.Student;
import vo.Teacher;

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
		
		try {
			service.addPerson(s1.getSsn(), s1);
			service.addPerson(s2.getSsn(), s2);
			service.addPerson(s3.getSsn(), s3);
			service.addPerson(t1.getSsn(), t1);
			service.addPerson(t2.getSsn(), t2);
			service.addPerson(e1.getSsn(), e1);
		} catch (DuplicateSSNException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n2. deletePerson()");
		
		try {
			service.deletePerson(s2.getSsn());
			service.deletePerson(s2.getSsn());
		} catch (RecordNotFoundException e) {
			System.out.println("\n2. deletePerson()");
		}
		
		System.out.println("\n3. findPerson()");
		
		ArrayList<Person> plist = service.findPerson("경기도");
		for(Person p : plist){
			System.out.println(p);
		}
		
		System.out.println("\n4. updatePerson()");
		
	}
}
