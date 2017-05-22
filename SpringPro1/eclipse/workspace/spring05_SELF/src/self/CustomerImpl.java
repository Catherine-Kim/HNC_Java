package self;

public class CustomerImpl implements Customer{
	// field
	private String name;
	private int ssn;
	private String addr;
	private Account acc;
	
	// constructor
	public CustomerImpl(String n, int s, String a) {
		super();
		this.name = n;
		this.ssn = s;
		this.addr = a;
	}
	
	//setter
	public void setAcc(Account acc) {
		this.acc = acc;
	}	

	@Override
	public String getCustomer() {
		return "Name :: " + name + "\nSSN :: " + ssn + "\nAddress :: " + addr;
	}

	@Override
	public Account getAccount() {
		return this.acc;
	}
}
