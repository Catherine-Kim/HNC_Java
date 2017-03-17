package child;

import parent.Employee;

public class Designer extends Employee{
	boolean canJQuery;
	
	// constructor
	public Designer(String empId, String name, String address, int salary, boolean canJQuery) {
		super(empId, name, address, salary);
		this.canJQuery = canJQuery;
	}
	
	// toString() Override
	@Override
	public String toString() {
		if(canJQuery)
			return super.toString() + "\tjQuery O";
		else
			return super.toString() + "\tjQuery X";
	}

	// getter() / setter()
	public boolean isCanJQuery() {
		return canJQuery;
	}

	public void setCanJQuery(boolean canJQuery) {
		this.canJQuery = canJQuery;
	}
}
