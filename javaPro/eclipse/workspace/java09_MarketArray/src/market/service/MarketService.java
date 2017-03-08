package market.service;

import market.vo.CustomerVO;
import market.vo.ProductVO;

/*
 * 상품을 구입한 고객, Market에 입점된 상품에 관련된
 * 정보를 다루는 기능 중심의 Service 클래스.
 * service 기능들을 정의할때
 * 중요한 부분이 메소드의 인자값, 리턴타입, 이름을 잘 지정해야 한다.
 */
public class MarketService {
	//1. 어떤(특정한) 고객이 구입한 상품들의 모든 MAKER이름을 콘솔로 출력하는 기능
	public void printAllProduct(CustomerVO cust){
		System.out.println("=====1. "+cust.getName()+
		                  " 고객께서 구입한 상품들 목록입니다.=====");
		ProductVO[ ] product=cust.getProducts();
		for(ProductVO vo : product){
			System.out.print(vo.getMaker()+"\t"+vo.getPrice());
			System.out.println(" ");
		}	
	}
	
	//2. 해당 Market에서 물건을 구입하려하는 모든 고객들의 정보를 콘솔로 출력
	//   고객들의 이름과 주소만 출력되도록...
	public void printAllCustomer(CustomerVO[ ] custs){
		System.out.println("\n=====2. Market의 모든 고객들 정보입니다..=====");
		for(CustomerVO vo : custs){
			System.out.print(vo.getName()+"\t"+vo.getAddress());
			System.out.println(" ");
		}
	}
	
	/*
	 * 3. 특정 고객이 구입한 모든 상품들을 리턴받음.
	 *    이때 10만원이 넘는 고가 제품만 maker와 가격이 콘솔로 출력
	 */
	public ProductVO[ ] getHighPriceProduct(CustomerVO cust, ProductVO[ ] pros){
		for(ProductVO vo : pros){
			if(vo.getPrice()>=100000){
				System.out.print(vo.getMaker()+"\t"+vo.getPrice());
				System.out.println(" ");
			}//if
		}//for
		return pros;
	}
	
	//4. 특정 고객이 구입한 물건중 금액이 가장 비싼 물건의 목록을 출력
	//   금액이 리턴되도록 하세요.
	public int getMaxPriceProduct(CustomerVO cust){
		ProductVO[ ] products=cust.getProducts();
		int max = products[0].getPrice();
		for(ProductVO vo : products){
			if(vo.getPrice()>max) 
				max = vo.getPrice();
			
		}
		return max;
	}
}





















