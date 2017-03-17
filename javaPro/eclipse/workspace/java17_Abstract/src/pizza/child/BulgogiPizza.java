package pizza.child;

import pizza.parent.Pizza;

public class BulgogiPizza extends Pizza{
	public BulgogiPizza(){};
	public BulgogiPizza(int price, String storeName){
		super();
		this.price = price;
		this.storeName = storeName;
	}
	@Override
	public void topping() {
		System.out.println("Topping with Bulgogi..");
	}
}
