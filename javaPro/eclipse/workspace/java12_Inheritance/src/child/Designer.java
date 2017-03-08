package child;

import parent.Employee;
import util.MyDate;

public class Designer extends Employee{
	boolean canJQuery;
	public Designer(String name, MyDate birthday, double salary, boolean canJQuery){
		super(name, birthday, salary);
		this.canJQuery = canJQuery;
	}
	
	@Override
	public String getDetails() {
		if(canJQuery)
			return super.getDetails() + "\tJQuery O";
		else
			return super.getDetails() + "\tJQuery X";
	}
}
