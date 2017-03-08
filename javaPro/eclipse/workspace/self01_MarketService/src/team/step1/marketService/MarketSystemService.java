package team.step1.marketService;

import team.step1.marketVO.CustomerVO;
import team.step1.marketVO.KostaMarketVO;
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
	
	//고객이 제품을 구매(고객의 expense에 지불한 금액을 더함,  pro를 고객의 산 물품 리스트에 넣음)
	public void buyProduct(CustomerVO cus, ProductVO[] pros){
		int totalPrice = 0;
		for(ProductVO pv : pros){
			totalPrice += pv.getPrice() * pv.getCount();
		}
		cus.setExpense(cus.getExpense() + totalPrice);
		cus.setProductList(pros);
	}
	
	//6.고객이 구매한 제품 중 가장 고가의 제품 출력 getMaxPriceProduct(){}
	public void getMaxPriceProduct(CustomerVO cus){
		System.out.println("=====6.고객이 구매한 제품 중 가장 고가의 제품 출력=====");
		int max = cus.getProductList()[0].getPrice();
		ProductVO temp;
		for(ProductVO vo : cus.getProductList()){
			if(max<vo.getPrice())
				max=vo.getPrice();
		}
		for(ProductVO vo : cus.getProductList()){
				if(max==vo.getPrice())
					System.out.println(vo.getBrand());	
		}
					
	}//getMaxPriceProduct
}//class


}