package parent;

/*
 * name, birthDate, salary��� �Ӽ��� �Ϲ����� �Ӽ����� ������ Employee Ŭ����
 * �θ�(Parent, Super) Ŭ�����μ� ���
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
