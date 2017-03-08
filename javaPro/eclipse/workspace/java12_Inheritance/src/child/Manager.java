package child;

import parent.Employee;
import util.MyDate;

public class Manager extends Employee{
	private String dept;
	
	public Manager(String name, MyDate birthday, double salary, String dept) {
		super(name, birthday, salary);
		this.dept = dept;
	}
	
	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return super.getDetails() + "\t" + dept;
	}
	
	// �μ� ���� �޼ҵ�
	public void changeDept(String dept){
		this.dept = dept;
	}
}
