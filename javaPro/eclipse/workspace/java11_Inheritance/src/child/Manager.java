package child;

import parent.Employee;
import util.MyDate;

/*
 * Employee Ŭ�����κ��� ��� ������ �����޴� �ڽ� Ŭ����
 * Manager ���� ����� dept(department) �ʵ� �߰�
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

// Manager �ı��� 5��
