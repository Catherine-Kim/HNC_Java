package pizza.parent;

public abstract class Pizza {
	protected int price;
	protected String storeName;
	
	public Pizza(){};
	public Pizza(int price, String storeName){
		super();
		this.price = price;
		this.storeName = storeName;
	}
	
	public void dough(){
		System.out.println("피자 반죽과 함께 도우를 만든다.");
	}
	
	// abstract method
	public abstract void topping();
	
	public void bake(){
		System.out.println("180도에서 피자 도우를 굽는다.");
	}
	public void cut(){
		System.out.println("8등분으로 피자를 자른다.");
	}
	public void boxing(){
		System.out.println("종이상자에 자른 피자를 잘 담는다.");
	}
	
	public void makePizza(){
		dough();
		topping();
		bake();
		cut();
		boxing();
	}
	
	@Override
	public String toString() {
		return storeName + " " + price;
	}
}

