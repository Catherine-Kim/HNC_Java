package market.service;

import market.vo.CustomerVO;
import market.vo.ProductVO;

/*
 * ��ǰ�� ������ ��, Market�� ������ ��ǰ�� ���õ�
 * ������ �ٷ�� ��� �߽��� Service Ŭ����.
 * service ��ɵ��� �����Ҷ�
 * �߿��� �κ��� �޼ҵ��� ���ڰ�, ����Ÿ��, �̸��� �� �����ؾ� �Ѵ�.
 */
public class MarketService {
	//1. �(Ư����) ���� ������ ��ǰ���� ��� MAKER�̸��� �ַܼ� ����ϴ� ���
	public void printAllProduct(CustomerVO cust){
		System.out.println("=====1. "+cust.getName()+
		                  " ������ ������ ��ǰ�� ����Դϴ�.=====");
		ProductVO[ ] product=cust.getProducts();
		for(ProductVO vo : product){
			System.out.print(vo.getMaker()+"\t"+vo.getPrice());
			System.out.println(" ");
		}	
	}
	
	//2. �ش� Market���� ������ �����Ϸ��ϴ� ��� ������ ������ �ַܼ� ���
	//   ������ �̸��� �ּҸ� ��µǵ���...
	public void printAllCustomer(CustomerVO[ ] custs){
		System.out.println("\n=====2. Market�� ��� ���� �����Դϴ�..=====");
		for(CustomerVO vo : custs){
			System.out.print(vo.getName()+"\t"+vo.getAddress());
			System.out.println(" ");
		}
	}
	
	/*
	 * 3. Ư�� ���� ������ ��� ��ǰ���� ���Ϲ���.
	 *    �̶� 10������ �Ѵ� �� ��ǰ�� maker�� ������ �ַܼ� ���
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
	
	//4. Ư�� ���� ������ ������ �ݾ��� ���� ��� ������ ����� ���
	//   �ݾ��� ���ϵǵ��� �ϼ���.
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





















