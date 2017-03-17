package poly.step4.test;

import java.util.Vector;

import poly.step4.test.Product;

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
	
	//***************************************************얘네 Vector로 추가
	Vector<Product> items = new Vector<Product>();
	int index = 0;
	
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
		//***************************************************얘네 Vector로 index 부분 수정
		items.add(pro);
		index++;
		System.out.println(pro + "를 구입하셨습니다.");
	}
		
	public void refundProduct(Product pro){
		// 상품이 저장된 배열을 for로 돌다가 환불하고자 하는 상품의 pNo와 일치하는 상품이 있다면
		// 해당 상품을 저장소에서 빼야한다.
		// money와 bonusPoint도 원래대로 돌려놓아야함
		//***************************************************얘네 Vector로 index 부분 수정
		if(items.remove(pro)){
			money += pro.price;
			bonusPoint -= pro.bonusPoint;
			System.out.println("환불 끝남요");
		}		
	}
	
	
	public void summary(){
		int sum = 0;
		String itemList = "";
		//***************************************************얘네 Vector로 for문 부분 수정
		if(items.isEmpty()){
			System.out.println("아직 아무것도 안 샀네요.");
		}
		for(int i = 0; i < items.size(); i++){
			Product p = items.get(i);
			sum += p.price;
			itemList += p + " ";
		}
		System.out.println("구입한 상품의 총 금액 : " + sum + "만원");
		System.out.println("구입한 상품의 총 목록 : " + itemList + "만원");
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
		System.out.println("현재 남은 금액 : " + service.money);
		System.out.println("현재 보너스포인트 : " + service.bonusPoint);
		service.summary();
		service.refundProduct(com);
		service.summary();
	}
}
