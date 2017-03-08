package vo.child;

import vo.parent.Person;

public class Teacher extends Person{
	private String subject;
	private String DEFAULT_SUBJECT = "¾øÀ½";
	
	public Teacher(){
		super();
		this.subject = DEFAULT_SUBJECT;
	}
	
	public Teacher(String name, int ssn, String address, String subject){
		super(name, ssn, address);
		this.subject = subject;
	}
	
	public void changeSubject(String subject){
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t" + subject;
	}
}
