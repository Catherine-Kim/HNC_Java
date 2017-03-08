package team.step1.marketService;

import team.step1.marketVO.CustomerVO;
import team.step1.marketVO.ProductVO;

public class OVMarketSystemService {
	public void printAll(CustomerVO[ ] custs){
		for(CustomerVO cv : custs)
			System.out.println(cv.getName());
	}
	
	//��ǰ ����Ʈ�� ���ڷ� �޾� ��ǰ�� name, price, count ���
	public void printAll(ProductVO[ ] pros){
		for(ProductVO pv : pros){
			System.out.println(pv.getBrand());
		}
	}
	
	
	// ��ǰ ����Ʈ�� ���ڷ� �޾� ��ǰ���� �� ���� ���
	public void printTotalPrice(ProductVO[] pros){
		int sum = 0;
		for(ProductVO pv : pros){
			sum += pv.getCount() * pv.getPrice();
		}
		System.out.println("Total Price is " + sum);
	}
	
	//���� ���ڷ� �޾� ���� �� ��ǰ �� ������ 50 �̻��� �͵��� brand ���
	public void printProductAbove50(CustomerVO cust){
		for(ProductVO pv : cust.getProductList()){
			if(pv.getPrice() >= 50){
				System.out.println(pv.getBrand());
			}
		}
	}
	//-----------------------------------Advanced-----------------------------------
	// �� Ŭ���� �� expense ����ؼ� ����(set)
	public void setExpense(CustomerVO cus){
		int totalExpense = 0;
		for(ProductVO pv : cus.getProductList()){
			totalExpense += pv.getCount() * pv.getPrice();
		}
		cus.setExpense(totalExpense);
	}
	
	
}
