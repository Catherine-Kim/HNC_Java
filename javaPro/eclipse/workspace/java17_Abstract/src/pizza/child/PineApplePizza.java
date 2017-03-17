package pizza.child;

import pizza.parent.Pizza;

public class PineApplePizza extends Pizza{
	public PineApplePizza(){};
	public PineApplePizza(int price, String storeName){
		super();
		this.price = price;
		this.storeName = storeName;
	}
	@Override
	public void topping() {
		System.out.println("Topping with Pineapple..");
	}
}
