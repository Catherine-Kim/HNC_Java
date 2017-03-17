package pizza.child;

import pizza.parent.Pizza;

public class PotatoPizza extends Pizza{
	public PotatoPizza(){};
	public PotatoPizza(int price, String storeName){
		super();
		this.price = price;
		this.storeName = storeName;
	}
	@Override
	public void topping() {
		System.out.println("Topping with potato..");
	}
}
