package child;

import parent.Employee;
import util.MyDate;

/*
 * Employee 클래스로부터 모든 성질을 물려받는 자식 클래스
 * Manager 만의 멤버로 dept(department) 필드 추가
 */

public class Manager extends Employee{

	private String dept;
	
	public Manager(String name, MyDate birthday, double salary, String dept){
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
		this.dept = dept;
	}
	
	public String getDetails(){
		return name + "\t" + birthday + "\t" + salary + "\t" + dept;
	}
}

// Manager 식구는 5명
