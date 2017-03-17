package poly.step3.test;

import poly.step3.test.Product;

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
	
	//***************************************************��� �߰�
	Product[] items = new Product[10];
	int index = 0;
	
	//***************************************************��� ����
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
		items[index] = pro;
		index++;
		System.out.println(pro + "�� �����ϼ̽��ϴ�.");
	}
	
	//***************************************************��� �߰�
	public void refundProduct(Product pro){
		// ��ǰ�� ����� �迭�� for�� ���ٰ� ȯ���ϰ��� �ϴ� ��ǰ�� pNo�� ��ġ�ϴ� ��ǰ�� �ִٸ�
		// �ش� ��ǰ�� ����ҿ��� �����Ѵ�.
		// money�� bonusPoint�� ������� �������ƾ���
		for(int i = 0; i < items.length; i++){
			if(items[i].getpNo() == pro.getpNo()){
				/*pb.items[i] = null;
				index--;
				money += pb.items[i].price;
				bonusPoint -= pb.items[i].bonusPoint;*/
				// �� ��ǰ���� ������ ���
				money += items[i].price;
				bonusPoint -= items[i].bonusPoint;
				for(int j = i; j < items.length - 1; j++){
					items[j] = items[j+1];
				}
				break;
			}
		}
		
		// ���ŵǾ����� Ȯ���ϴ� for��
		for(Product p : items){
			if(p == null) break;
			System.out.println(p);
		}
		
	}
	
	//***************************************************��� �߰�
	public void summary(){
		int sum = 0;
		String itemList = "";
		for(Product p : items){
			if(p == null) break;
			sum += p.price;
			itemList += p + " ";
		}
		System.out.println("������ ��ǰ�� �� �ݾ� : " + sum + "����");
		System.out.println("������ ��ǰ�� �� ��� : " + itemList + "����");
	}
}

public class ProductBuyerTest3 {
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
