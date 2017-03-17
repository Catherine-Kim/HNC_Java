package pizza.child;

import pizza.parent.Pizza;

public class CheesePizza extends Pizza{
	public CheesePizza(){};
	public CheesePizza(int price, String storeName){
		super();
		this.price = price;
		this.storeName = storeName;
	}
	@Override
	public void topping() {
		System.out.println("Topping with cheese..");
	}
}
