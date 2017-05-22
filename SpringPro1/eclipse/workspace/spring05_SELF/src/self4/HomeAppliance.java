package self4;

public class HomeAppliance {
	// field
	private String maker;
	private String productName;
	
	// constructor
	public HomeAppliance(){ }

	// getter & setter
	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Override
	public String toString() {
		return "Home Appliance :: " + productName + "(" + maker + ")";
	}
}
