package child;

import parent.Employee;
import util.MyDate;

public class Engineer extends Employee{
	private String tech;
	public Engineer(String name, MyDate birthday, double salary, String tech){
		super(name, birthday, salary);
		this.tech = tech;
	}
	
	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return super.getDetails() + "\t" + tech;
	}
}
