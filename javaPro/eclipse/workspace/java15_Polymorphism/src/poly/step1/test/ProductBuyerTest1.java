package poly.step1.test;

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
	
	public void buyTV(TV tv){
		// ���� ������ ��ǰ�� ������ �۰ų� ���� ���� ������ �� �ִ�.
		// ��ǰ ���ݸ�ŭ �����ݾ��� �پ���, ����Ʈ�� �ö󰣴�
		// ���������� ������ ��ǰ���� ���
		if(money >= tv.price){
			money -= tv.price;
			bonusPoint += tv.bonusPoint;
			System.out.println(tv + "�� �����ϼ̽��ϴ�.");
		}
		else{
			System.out.println("TV�� �� ���� �����ʴϴ�.");
		}
	}
	
	public void buyComputer(Computer com){
		// ���� ������ ��ǰ�� ������ �۰ų� ���� ���� ������ �� �ִ�.
		// ��ǰ ���ݸ�ŭ �����ݾ��� �پ���, ����Ʈ�� �ö󰣴�
		// ���������� ������ ��ǰ���� ���
		if(money >= com.price){
			money -= com.price;
			bonusPoint += com.bonusPoint;
			System.out.println(com + "�� �����ϼ̽��ϴ�.");
		}
		else{
			System.out.println("��ǻ�͸� �� ���� �����ʴϴ�.");
		}
	}
	
}

public class ProductBuyerTest1 {
	public static void main(String[] args){
		TV tv = new TV();
		Computer com = new Computer();
		ProductBuyer service = new ProductBuyer();
		
		service.buyTV(tv);
		service.buyTV(tv);
		service.buyComputer(com);
		System.out.println("���� ���� �ݾ� : " + service.money);
		System.out.println("���� ���ʽ�����Ʈ : " + service.bonusPoint);
	}
}
