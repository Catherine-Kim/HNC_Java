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
		System.out.println("���� ���װ� �Բ� ���츦 �����.");
	}
	
	// abstract method
	public abstract void topping();
	
	public void bake(){
		System.out.println("180������ ���� ���츦 ���´�.");
	}
	public void cut(){
		System.out.println("8������� ���ڸ� �ڸ���.");
	}
	public void boxing(){
		System.out.println("���̻��ڿ� �ڸ� ���ڸ� �� ��´�.");
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

