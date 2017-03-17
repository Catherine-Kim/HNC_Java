package service;

import child.Designer;
import child.Engineer;
import child.Manager;
import parent.Employee;

public class EmployeeService {

	// ��Ӱ� Override�� ��� ����
	public void printInfoEmployee(Employee e){
		System.out.println(e);
	}
	
	// ��� Employee�� ����ϱ� ���� printInfoEmployee() �޼ҵ� Overloading
	public void printInfoEmployee(Employee[] elist){
		for(Employee e : elist){
			System.out.println(e);
		}
	}
	
	// ���ڷ� empID�� �޾� �׿� ��ġ�ϴ� empID�� ���� Employee Ŭ���� ã��(Employee Ŭ���� ����)
	public Employee findEmployeeByEmpID(String empID, Employee[] elist){
		
		/*for(Employee e : elist){
			if(e.getEmpId() == empID)
				return e;
		}
		 return null;*/
		
		Employee eToReturn = null;
		for(Employee e : elist){
			if(e.getEmpId().equals(empID))
				eToReturn = e;
		}
		if(eToReturn == null)
			System.out.println("�׷� ID �����ϴ�.");
		return eToReturn;
	}
	
	// ���ڷ� address�� �޾� �׿� ��ġ�ϴ� address�� ���� Employee Ŭ���� ã�� 
	// ���� �ּҸ� ���� ����� ������ �� ������ Employee[]�� �����ؾ߰���
	public Employee[] findEmployeeByAddress(String address, Employee[] elist){
		Employee[] elistToReturn = new Employee[elist.length];
		for(int i = 0; i < elistToReturn.length; i++){
			elistToReturn[i] = new Employee();
		}
		
		int index = 0;
		for(Employee e : elist){
			if(e.getAddress().equals(address)){
				elistToReturn[index] = e;
				index++;
			}
		}
		return elistToReturn;
	}
	
	// Ư�� Employee�� ������ ����(���ʽ��� ����)
	public int getAnnualSalary(Employee e){
		int annualSalary = 0;
		if(e instanceof Engineer)
			annualSalary = ((Engineer)e).getSalary() * 12 + ((Engineer)e).getBonus();
		else 
			annualSalary = e.getSalary() * 12;
		return annualSalary;
	}
	
	// ���� �� �ΰǺ� ����
	public int getTotalSalary(Employee[] elist){
		int totalSalary = 0;
		
		for(Employee e : elist){
			totalSalary += getAnnualSalary(e);
		}
		return totalSalary;
	}
}
