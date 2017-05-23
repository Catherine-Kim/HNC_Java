package kosta.model;

public class CustomerImpl implements Customer{
	@Override
	public void insertCustomer(String info) {
		System.out.println("[SUCCESS] insertCustomer() - Customer Info : " + info);
		
	}

	@Override
	public void register(String ssn, String name) {
		System.out.println("[SUCCESS] register() - Customer SSN : " + ssn + 
												", Customer Name : " + name);
	}
}
