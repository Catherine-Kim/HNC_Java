package poly.step3.test;

import poly.step3.test.Product;

class Product {		// 슈퍼클래스
	int price;
	int bonusPoint;
	int pNo;
	
	// 상품가의 10%가 보너스가 되도록 객체 생성
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

class TV extends Product{		// 서브클래스
	TV(){
		super(150);
	};
	
	@Override
	public String toString() {
		return "TV";
	}
}

class Computer extends Product{	// 서브 클래스
	Computer(){
		super(100);
	};
	
	@Override
	public String toString() {
		return "Computer";
	}
}

class Audio extends Product{	// 서브 클래스
	Audio(){
		super(100);
	};
	
	@Override
	public String toString() {
		return "Audio";
	}
}

class ProductBuyer{				// 가진 돈 1,000만원
	int money = 1000;
	int bonusPoint = 0;
	
	//***************************************************얘네 추가
	Product[] items = new Product[10];
	int index = 0;
	
	//***************************************************얘네 수정
	public void buyProduct(Product pro){
		// 가진 돈보다 상품 가격이 크면 return
		// 상품가만큼 돈은 빠지고, 보너스 포인트는 증가
		// 배열 첫 번째 항목에 해당 상품을 할당하고, index 증가
		if(money < pro.price){
			System.out.println("이걸 살 돈이 없으세요");
			return;
		}
		
		money -= pro.price;
		bonusPoint += pro.bonusPoint;
		items[index] = pro;
		index++;
		System.out.println(pro + "를 구입하셨습니다.");
	}
	
	//***************************************************얘네 추가
	public void refundProduct(Product pro){
		// 상품이 저장된 배열을 for로 돌다가 환불하고자 하는 상품의 pNo와 일치하는 상품이 있다면
		// 해당 상품을 저장소에서 빼야한다.
		// money와 bonusPoint도 원래대로 돌려놓아야함
		for(int i = 0; i < items.length; i++){
			if(items[i].getpNo() == pro.getpNo()){
				/*pb.items[i] = null;
				index--;
				money += pb.items[i].price;
				bonusPoint -= pb.items[i].bonusPoint;*/
				// 뒤 상품들을 앞으로 덮어씀
				money += items[i].price;
				bonusPoint -= items[i].bonusPoint;
				for(int j = i; j < items.length - 1; j++){
					items[j] = items[j+1];
				}
				break;
			}
		}
		
		// 제거되었는지 확인하는 for문
		for(Product p : items){
			if(p == null) break;
			System.out.println(p);
		}
		
	}
	
	//***************************************************얘네 추가
	public void summary(){
		int sum = 0;
		String itemList = "";
		for(Product p : items){
			if(p == null) break;
			sum += p.price;
			itemList += p + " ";
		}
		System.out.println("구입한 상품의 총 금액 : " + sum + "만원");
		System.out.println("구입한 상품의 총 목록 : " + itemList + "만원");
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
		System.out.println("현재 남은 금액 : " + service.money);
		System.out.println("현재 보너스포인트 : " + service.bonusPoint);
		service.summary();
		service.refundProduct(com);
		service.summary();
	}
}
