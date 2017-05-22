package self2;

import java.util.ArrayList;

public class CustomerImpl implements Customer{
	// field
	private String name;
	private int ssn;
	private String address;
	private ArrayList<Account> list;	// Account를 ArrayList<Account>로 변경
	
	// constructor
	public CustomerImpl(String name, int ssn, String address) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.address = address;
	}
	
	// setter
	public void setList(ArrayList<Account> list) {
		this.list = list;
	}	

	@Override
	public String getCustomer() {
		return "Name :: " + name + "\nSSN :: " + ssn + "\nAddress :: " + address;
	}

	@Override
	public ArrayList<Account> getAccount() {
		return list;
	}
}
