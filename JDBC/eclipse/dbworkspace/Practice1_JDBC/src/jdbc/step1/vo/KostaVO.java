package jdbc.step1.vo;

public class KostaVO {
	// fields
	private String id;
	private String name;
	private String address;
	
	// constructor
	public KostaVO(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public KostaVO(){};

	// getters and setters
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return id + " / " + name + " / " + "address";
	}
}
