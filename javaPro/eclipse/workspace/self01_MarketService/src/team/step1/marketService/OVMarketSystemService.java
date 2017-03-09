package team.step1.marketService;

import team.step1.marketVO.CustomerVO;
import team.step1.marketVO.ProductVO;

public class OVMarketSystemService {
	// �� ����Ʈ�� ���ڷ� �޾� ������ name ���
	public void printAll(CustomerVO[ ] custs){
		for(CustomerVO cv : custs)
			System.out.println(cv.getName());
	} // printAll ��
	
	//��ǰ ����Ʈ�� ���ڷ� �޾� ��ǰ�� brand ���
	public void printAll(ProductVO[ ] pros){
		for(ProductVO pv : pros){
			System.out.println(pv.getBrand());
		}
	} // printAll ��
	
	// ���� ���ڷ� �޾� ��ǰ�� brand ���
	public void printAll(CustomerVO cust){
		for(ProductVO pv : cust.getProductList()){
			System.out.println(pv.getBrand());
		}
	} // printAll ��
	
	
	// ��ǰ ����Ʈ�� ���ڷ� �޾� ��ǰ���� �� ���� ���
	public void printTotalPrice(CustomerVO cust){
		int sum = 0;
		for(ProductVO pv : cust.getProductList()){
			sum += pv.getCount() * pv.getPrice();
		}
		System.out.println("Total Price is " + sum);
	} // printTotalPrice ��
	
	//���� ���ڷ� �޾� ���� �� ��ǰ �� ������ 50 �̻��� �͵��� brand ���
	public void printProductAbove50(CustomerVO cust){
		for(ProductVO pv : cust.getProductList()){
			if(pv.getPrice() >= 50){
				System.out.println(pv.getBrand());
			}
		}
	} // printProductAbove50 ��
	
	//-----------------------------------Advanced-----------------------------------
	public void getMaxPriceProduct(CustomerVO cus){
		//System.out.println("=====6.���� ������ ��ǰ �� ���� ���� ��ǰ ���=====");
		int max = cus.getProductList()[0].getPrice();
		ProductVO temp;
		for(ProductVO vo : cus.getProductList()){ 	// max ���ϱ�
			if(max<vo.getPrice())
				max=vo.getPrice();
		}
		for(ProductVO vo : cus.getProductList()){   // price�� max�� ��ġ�ϴ� ��� ã��
				if(max==vo.getPrice())
					System.out.println(vo.getBrand());	
		}
	} // getMaxPriceProduct ��
	

	//���� ��ǰ�� ����(���� expense�� ������ �ݾ��� ����,  pro�� ���� �� ��ǰ ����Ʈ�� ����)
	public void buyProduct(CustomerVO cus, ProductVO[] pros){
		int totalPrice = 0;
		for(ProductVO pv : pros){
			totalPrice += pv.getPrice() * pv.getCount();
		}
		cus.setExpense(cus.getExpense() + totalPrice);
		cus.setProductList(pros);
		System.out.println(cus.getName() + "���� ���Ű� ���������� �̷�������ϴ�.");
	} // buyProduct ��
}
