package vo.child;

import vo.parent.Person;

public class Manager extends Person{
	private String dept;
	private String DEFAULT_DEPT = "¾øÀ½";
	
	public Manager(){
		super();
		this.dept = DEFAULT_DEPT;
	}
	
	public Manager(String name, int ssn, String address, String dept){
		super(name, ssn, address);
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t" + dept;
	}
}
