package service;

import child.Designer;
import child.Engineer;
import child.Manager;
import parent.Employee;

public class EmployeeService {

	// 상속과 Override를 배운 지금
	public void printInfoEmployee(Employee e){
		System.out.println(e);
	}
	
	// 모든 Employee를 출력하기 위해 printInfoEmployee() 메소드 Overloading
	public void printInfoEmployee(Employee[] elist){
		for(Employee e : elist){
			System.out.println(e);
		}
	}
	
	// 인자로 empID를 받아 그와 일치하는 empID를 가진 Employee 클래스 찾기(Employee 클래스 리턴)
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
			System.out.println("그런 ID 없습니다.");
		return eToReturn;
	}
	
	// 인자로 address를 받아 그와 일치하는 address를 가진 Employee 클래스 찾기 
	// 같은 주소를 가진 사람이 여럿일 수 있으니 Employee[]을 리턴해야겠지
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
	
	// 특정 Employee의 연봉을 리턴(보너스도 포함)
	public int getAnnualSalary(Employee e){
		int annualSalary = 0;
		if(e instanceof Engineer)
			annualSalary = ((Engineer)e).getSalary() * 12 + ((Engineer)e).getBonus();
		else 
			annualSalary = e.getSalary() * 12;
		return annualSalary;
	}
	
	// 연간 총 인건비 리턴
	public int getTotalSalary(Employee[] elist){
		int totalSalary = 0;
		
		for(Employee e : elist){
			totalSalary += getAnnualSalary(e);
		}
		return totalSalary;
	}
}
