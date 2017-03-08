package market.test;

import market.service.MarketService;
import market.util.MyDate;
import market.vo.CustomerVO;
import market.vo.ProductVO;

public class MarketServiceTest {
	public static void main(String[] args) {
		//1. ���� ����...2��
		CustomerVO cust1 = new CustomerVO("������", "������", 000);
		
		CustomerVO[ ] custs = {
				new CustomerVO("������", "������", 77889),
				new CustomerVO("�α���", "���е�", 11223),
				cust1
		};
		
		//2.��ǰ�迭�� ����...2�� �����. 
		//pros1, pros2
		ProductVO[ ] pros1 = {
				new ProductVO("�����", 3400, 111, new MyDate(2017, 3, 2)),
				new ProductVO("ȣ�ΰ���", 2700, 222, new MyDate(2017, 3, 10)),
				new ProductVO("���ǽ�", 120000, 333, new MyDate(2016, 11, 22)),
				new ProductVO("�����佺", 200, 444, new MyDate(2017, 3, 3)),
				new ProductVO("��������", 4000, 555, new MyDate(2017, 3, 4))
		};
		
		ProductVO[ ] pros2 = {
				new ProductVO("�ƽ�Ŀ��", 27000, 666, new MyDate(2017, 1, 2)),
				new ProductVO("��������ǰ", 330000, 777, new MyDate(2016, 12, 10)),
				new ProductVO("�鵵��", 220000, 888, new MyDate(2017, 2, 1))
				
		};
		
		//3. �����̰� pros1, �α��ΰ� pros1�� �����ߴٴ� ǥ���� ������
		custs[0].buyProducts(pros1);
		custs[1].buyProducts(pros2);
		
		//4.
		MarketService service = new MarketService();
		
		//5. Service Ŭ������ ����� ȣ��
		service.printAllProduct(custs[0]);
		
		service.printAllCustomer(custs);
		
		//�α��ΰ� ������ ������ 10���� �̻��� ����ǰ���� ����..
		System.out.println("\n3.====10���� �� ��ǰ�� ������ �Դϴ�...====");
		service.getHighPriceProduct(custs[1], pros2);
		
		System.out.println("\n4.==========������ ��ǰ�� �ְ� ���� ���� =====");
		System.out.println("�α��� ���� ������ ������ �ְ� ��ǰ�Դϴ�.");
		System.out.println(service.getMaxPriceProduct(custs[1])+" �� �Դϴ�");

		// 6-1
		System.out.println(cust1);
		System.out.println(cust1.toString());
		
		
	}
}



















