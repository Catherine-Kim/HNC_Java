package cartbiz;

public class Cart {
	// field
	private String image;
	private String name;
	private int price;
	private int quantity;
	
	// constructor
	public Cart(){}
	
	public Cart(String image, String name, int price, int quantity) {
		super();
		this.image = image;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	// getters and setters
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [image=" + image + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
