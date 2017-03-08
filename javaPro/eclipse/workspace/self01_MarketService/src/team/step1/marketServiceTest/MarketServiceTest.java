package team.step1.marketServiceTest;

import team.step1.marketService.MarketSystemService;
import team.step1.marketVO.CustomerVO;
import team.step1.marketVO.KostaMarketVO;
import team.step1.marketVO.ProductVO;

public class MarketServiceTest {

	public static void main(String[] args) {
		
		// '명정현'이 구매한 제품 리스트
		ProductVO[] proMJH = {
				new ProductVO("KENZO", 35, 1),
				new ProductVO("BOSS", 25, 1),
				new ProductVO("Columbia", 55, 1),
				new ProductVO("Adidas", 5, 2)
		};
		
		// '이태현'이 구매한 제품 리스트
		ProductVO[] proLTH = {
			new ProductVO("Lacoste", 20, 3),
			new ProductVO("Beanpole", 15, 1)
		};
		
		// '이영욱'이 구매한 제품 리스트
		ProductVO[] proLYW= {
			new ProductVO("Nike", 10, 2),
			new ProductVO("Puma", 15, 2),
			new ProductVO("Moschino", 60, 1)
		};
		
		// '김우정'이 구매한 제품 리스트
		ProductVO[] proKWJ = {
			new ProductVO("Lush", 5, 10),
			new ProductVO("Metrocity", 15, 1),
			new ProductVO("Moschino", 20, 1),
			new ProductVO("Givenchy", 55, 1),
			new ProductVO("Vans", 10, 3),
		};		
		
		// 네 명의 고객 리스트
		CustomerVO cusLTH = new CustomerVO("이태현", proMJH, 0);
		CustomerVO cusMJH = new CustomerVO("명정현", proLTH, 0);
		CustomerVO cusLYW = new CustomerVO("이영욱", proLYW, 0);
		CustomerVO cusKWJ = new CustomerVO("김우정", proKWJ, 0);
		
		CustomerVO[] customerList = {cusLTH, cusMJH, cusLYW, cusKWJ};
		
		
		// MarketSystemService 객체 생성
		MarketSystemService kosta = new MarketSystemService();

		//-------------------------------------------객체  생성 및 초기화 끄읕-------------------------------------------
		
		//고객 리스트 출력
		kosta.printAllCustomer(customerList);
		System.out.println("\n");
		
		//제품 리스트 출력
		kosta.printAllProduct(proKWJ);
		System.out.println("\n");
		
		//고객이 산 물품 중에서 50만원 이상의 물품 출력
		kosta.printProductAbove50(cusKWJ);
		System.out.println("\n");
		
		// 제품 리스트를 인자로 받아 제품들의 총 가격 출력
		kosta.printTotalPrice(proKWJ);
		System.out.println("\n");
		
	}

}
		


