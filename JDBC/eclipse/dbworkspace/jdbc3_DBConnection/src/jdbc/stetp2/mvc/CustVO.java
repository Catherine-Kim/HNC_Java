package jdbc.stetp2.mvc;

public class CustVO {
	// fields
	private String id;
	private String name;
	private String addr;
	
	// constructors
	public CustVO(){};
	
	public CustVO(String id, String name, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
	}
	
	// getters and setters
	public CustVO(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	@Override
	public String toString() {
		return "[" + id + "] " + name + "/" + addr;
	}
}
