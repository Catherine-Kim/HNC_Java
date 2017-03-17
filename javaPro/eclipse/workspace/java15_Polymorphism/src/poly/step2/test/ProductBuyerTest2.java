package poly.step2.test;

class Product {		// 슈퍼클래스
	int price;
	int bonusPoint;
	
	// 상품가의 10%가 보너스가 되도록 객체 생성
	Product(int price){
		this.price = price;
		bonusPoint = (int)(price/10);
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

class ProductBuyer{				// 가진 돈 1,000만원
	int money = 1000;
	int bonusPoint = 0;
	
	public void buyProduct(Product pro){
		// 가진 돈보다 상품의 가격이 작거나 같을 때만 구입할 수 있다.
		// 상품 가격만큼 보유금액은 줄어들고, 포인트는 올라간다
		// 최종적으로 구입한 상품정보 출력
		if(money >= pro.price){
			money -= pro.price;
			bonusPoint += pro.bonusPoint;
			System.out.println(pro + "을 구매하셨습니다.");
		}
		else{
			System.out.println("TV를 살 돈이 없으십니다.");
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
		System.out.println("현재 남은 금액 : " + service.money);
		System.out.println("현재 보너스포인트 : " + service.bonusPoint);
	}
}
