package poly.step2.test;

class Product {		// ����Ŭ����
	int price;
	int bonusPoint;
	
	// ��ǰ���� 10%�� ���ʽ��� �ǵ��� ��ü ����
	Product(int price){
		this.price = price;
		bonusPoint = (int)(price/10);
	}
}

class TV extends Product{		// ����Ŭ����
	TV(){
		super(150);
	};
	
	@Override
	public String toString() {
		return "TV";
	}
}

class Computer extends Product{	// ���� Ŭ����
	Computer(){
		super(100);
	};
	
	@Override
	public String toString() {
		return "Computer";
	}
}

class ProductBuyer{				// ���� �� 1,000����
	int money = 1000;
	int bonusPoint = 0;
	
	public void buyProduct(Product pro){
		// ���� ������ ��ǰ�� ������ �۰ų� ���� ���� ������ �� �ִ�.
		// ��ǰ ���ݸ�ŭ �����ݾ��� �پ���, ����Ʈ�� �ö󰣴�
		// ���������� ������ ��ǰ���� ���
		if(money >= pro.price){
			money -= pro.price;
			bonusPoint += pro.bonusPoint;
			System.out.println(pro + "�� �����ϼ̽��ϴ�.");
		}
		else{
			System.out.println("TV�� �� ���� �����ʴϴ�.");
		}
	}
}

public class ProductBuyerTest2 {
	public static void main(String[] args){
		TV tv = new TV();
		Computer com = new Computer();
		ProductBuyer service = new ProductBuyer();
		
		service.buyProduct(tv);
		service.buyProduct(tv);
		service.buyProduct(com);
		System.out.println("���� ���� �ݾ� : " + service.money);
		System.out.println("���� ���ʽ�����Ʈ : " + service.bonusPoint);
	}
}
