package vo.parent;

public class Person {
	private int ssn;
	private String name;
	private String address;
	
	private String DEFAULT_ADDRESS = "°æ»óºÏµµ ¿ïÁø±º";
	private String DEFAULT_NAME = "È«±æµ¿";
	private int DEFAULT_SSN = 123456;
	
	public Person(){
		this.ssn = DEFAULT_SSN;
		this.name = DEFAULT_NAME;
		this.address = DEFAULT_ADDRESS;
	}
	
	public Person(String name, int ssn, String address){
		this.name = name;
		this.ssn = ssn;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return ssn + "\t" + name + "\t" + address;
	}
}
