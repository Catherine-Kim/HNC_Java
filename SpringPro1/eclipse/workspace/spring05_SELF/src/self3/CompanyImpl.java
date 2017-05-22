package self3;

import java.util.ArrayList;

public class CompanyImpl implements Company{
	// field	
	private ArrayList<Employee> list;

	// setter	
	public void setList(ArrayList<Employee> list) {
		this.list = list;
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
		return list;
	}
}
