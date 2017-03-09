package team.step1.marketService;

import team.step1.marketVO.CustomerVO;
import team.step1.marketVO.ProductVO;

public class MarketSystemService {
	//고객 리스트를 인자로 받아 고객의 name 출력
	public void printAllCustomer(CustomerVO[ ] custs){
		for(CustomerVO cv : custs)
			System.out.println(cv.getName());
	}
	
	//제품 리스트를 인자로 받아 제품의 name, price, count 출력
	public void printAllProduct(ProductVO[ ] pros){
		for(ProductVO pv : pros){
			System.out.println(pv.getBrand());
		}
	}
	
	
	// 제품 리스트를 인자로 받아 제품들의 총 가격 출력
	public void printTotalPrice(ProductVO[] pros){
		int sum = 0;
		for(ProductVO pv : pros){
			sum += pv.getCount() * pv.getPrice();
		}
		System.out.println("Total Price is " + sum);
	}
	
	//고객을 인자로 받아 고객이 산 제품 중 가격이 50 이상인 것들의 brand 출력
	public void printProductAbove50(CustomerVO cust){
		for(ProductVO pv : cust.getProductList()){
			if(pv.getPrice() >= 50){
				System.out.println(pv.getBrand());
			}
		}
	}
}//class


