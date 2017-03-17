package poly.step4.test;

import java.util.Vector;

import poly.step4.test.Product;

class Product {		// ����Ŭ����
	int price;
	int bonusPoint;
	int pNo;
	
	// ��ǰ���� 10%�� ���ʽ��� �ǵ��� ��ü ����
	Product(int price){
		this.price = price;
		bonusPoint = (int)(price/10);
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
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

class Audio extends Product{	// ���� Ŭ����
	Audio(){
		super(100);
	};
	
	@Override
	public String toString() {
		return "Audio";
	}
}

class ProductBuyer{				// ���� �� 1,000����
	int money = 1000;
	int bonusPoint = 0;
	
	//***************************************************��� Vector�� �߰�
	Vector<Product> items = new Vector<Product>();
	int index = 0;
	
	public void buyProduct(Product pro){
		// ���� ������ ��ǰ ������ ũ�� return
		// ��ǰ����ŭ ���� ������, ���ʽ� ����Ʈ�� ����
		// �迭 ù ��° �׸� �ش� ��ǰ�� �Ҵ��ϰ�, index ����
		if(money < pro.price){
			System.out.println("�̰� �� ���� ��������");
			return;
		}
		
		money -= pro.price;
		bonusPoint += pro.bonusPoint;
		//***************************************************��� Vector�� index �κ� ����
		items.add(pro);
		index++;
		System.out.println(pro + "�� �����ϼ̽��ϴ�.");
	}
		
	public void refundProduct(Product pro){
		// ��ǰ�� ����� �迭�� for�� ���ٰ� ȯ���ϰ��� �ϴ� ��ǰ�� pNo�� ��ġ�ϴ� ��ǰ�� �ִٸ�
		// �ش� ��ǰ�� ����ҿ��� �����Ѵ�.
		// money�� bonusPoint�� ������� �������ƾ���
		//***************************************************��� Vector�� index �κ� ����
		if(items.remove(pro)){
			money += pro.price;
			bonusPoint -= pro.bonusPoint;
			System.out.println("ȯ�� ������");
		}		
	}
	
	
	public void summary(){
		int sum = 0;
		String itemList = "";
		//***************************************************��� Vector�� for�� �κ� ����
		if(items.isEmpty()){
			System.out.println("���� �ƹ��͵� �� ��׿�.");
		}
		for(int i = 0; i < items.size(); i++){
			Product p = items.get(i);
			sum += p.price;
			itemList += p + " ";
		}
		System.out.println("������ ��ǰ�� �� �ݾ� : " + sum + "����");
		System.out.println("������ ��ǰ�� �� ��� : " + itemList + "����");
	}
}

public class ProductBuyerTest4 {
	public static void main(String[] args){
		TV tv = new TV();
		Computer com = new Computer();
		ProductBuyer service = new ProductBuyer();
		Audio aud = new Audio();
		
		tv.setpNo(111);
		com.setpNo(222);
		aud.setpNo(333);
		
		service.buyProduct(tv);
		service.buyProduct(tv);
		service.buyProduct(com);
		service.buyProduct(aud);
		service.buyProduct(aud);
		System.out.println("���� ���� �ݾ� : " + service.money);
		System.out.println("���� ���ʽ�����Ʈ : " + service.bonusPoint);
		service.summary();
		service.refundProduct(com);
		service.summary();
	}
}
