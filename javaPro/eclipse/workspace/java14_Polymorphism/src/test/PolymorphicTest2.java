package test;

import child.Designer;
import child.Engineer;
import child.Manager;
import parent.Employee;
import service.EmployeeService;

public class PolymorphicTest2 {
	public static void main(String[] args) {
		Manager m1 = new Manager("m32", "Woojeong Kim", "경상북도 울진군", 9000, "Part A");
		Engineer eg1 = new Engineer("e07", "Jimin Park", "경상남도 진주시", 8000, "Java", 3000);
		Engineer eg2 = new Engineer("e19", "Jeonggook Jeon", "서울특별시 마포구", 7000, "Javascript", 3500);
		Designer d1 = new Designer("e07", "Tahyung Kim", "제주도 서귀포시", 8000, true);
		
		EmployeeService es = new EmployeeService();
	
		System.out.println("printInfoEmployee(Employee e) :: ");
		es.printInfoEmployee(m1);
		es.printInfoEmployee(eg1);
		es.printInfoEmployee(eg2);
		es.printInfoEmployee(d1);
		
		Employee[] elist = {m1, eg1, eg2, d1};
		
		System.out.println("\nprintInfoEmployee(Employee[] elist) :: ");
		es.printInfoEmployee(elist);
		
		System.out.println("\nfindEmployeeByEmpID(String empID, Employee[] elist) :: ");
		System.out.println(es.findEmployeeByEmpID("m32", elist));
		
		System.out.println("\nfindEmployeeByAddress(String address, Employee[] elist) :: ");
		Employee[] elistWithSameAddr = es.findEmployeeByAddress("경상북도 울진군", elist);
		for(Employee e : elistWithSameAddr){
			if(e == null) continue;
			System.out.println(e);
		}
		
		System.out.println("\ngetAnnualSalary(Employee e) :: ");
		System.out.println(es.getAnnualSalary(m1));
		System.out.println(es.getAnnualSalary(eg1));
		
		System.out.println("\ngetTotalSalary(Employee[] elist) ::");
		System.out.println(es.getTotalSalary(elist));
	}
}
