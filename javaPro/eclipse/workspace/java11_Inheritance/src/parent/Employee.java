package parent;

/*
 * name, birthDate, salary라는 속성을 일반적인 속성으로 가지는 Employee 클래스
 * 부모(Parent, Super) 클래스로서 사용
 */

import util.MyDate;

public class Employee {
	public String name;
	public MyDate birthday;
	public double salary;
	
	public Employee(){};
	
	public Employee(String name, MyDate birthday, double salary){
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
	}
	
	public String getDetails(){
		return name+"\t"+birthday+"\t"+salary;
	}
	
}
