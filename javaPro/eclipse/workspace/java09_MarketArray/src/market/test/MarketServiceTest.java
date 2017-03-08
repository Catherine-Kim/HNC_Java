package market.test;

import market.service.MarketService;
import market.util.MyDate;
import market.vo.CustomerVO;
import market.vo.ProductVO;

public class MarketServiceTest {
	public static void main(String[] args) {
		//1. 고객을 생성...2명만
		CustomerVO cust1 = new CustomerVO("명정현", "서현동", 000);
		
		CustomerVO[ ] custs = {
				new CustomerVO("도봉순", "도봉동", 77889),
				new CustomerVO("인국두", "방학동", 11223),
				cust1
		};
		
		//2.상품배열을 생성...2개 만든다. 
		//pros1, pros2
		ProductVO[ ] pros1 = {
				new ProductVO("진라면", 3400, 111, new MyDate(2017, 3, 2)),
				new ProductVO("호두과자", 2700, 222, new MyDate(2017, 3, 10)),
				new ProductVO("원피스", 120000, 333, new MyDate(2016, 11, 22)),
				new ProductVO("추파춥스", 200, 444, new MyDate(2017, 3, 3)),
				new ProductVO("초코파이", 4000, 555, new MyDate(2017, 3, 4))
		};
		
		ProductVO[ ] pros2 = {
				new ProductVO("맥심커피", 27000, 666, new MyDate(2017, 1, 2)),
				new ProductVO("디지털제품", 330000, 777, new MyDate(2016, 12, 10)),
				new ProductVO("면도기", 220000, 888, new MyDate(2017, 2, 1))
				
		};
		
		//3. 봉순이가 pros1, 인국두가 pros1을 구매했다는 표현을 가능케
		custs[0].buyProducts(pros1);
		custs[1].buyProducts(pros2);
		
		//4.
		MarketService service = new MarketService();
		
		//5. Service 클래스의 기능을 호출
		service.printAllProduct(custs[0]);
		
		service.printAllCustomer(custs);
		
		//인국두가 구매한 물건중 10만원 이상의 고가제품들의 정보..
		System.out.println("\n3.====10만원 고가 제품의 정보들 입니다...====");
		service.getHighPriceProduct(custs[1], pros2);
		
		System.out.println("\n4.==========구입한 제품중 최고가 물건 정보 =====");
		System.out.println("인국두 씨가 구매한 물건중 최고가 제품입니다.");
		System.out.println(service.getMaxPriceProduct(custs[1])+" 원 입니다");

		// 6-1
		System.out.println(cust1);
		System.out.println(cust1.toString());
		
		
	}
}



















