package team.step1.marketServiceTest;

import team.step1.marketService.MarketSystemService;
import team.step1.marketVO.CustomerVO;
import team.step1.marketVO.KostaMarketVO;
import team.step1.marketVO.ProductVO;

public class MarketServiceTest {

	public static void main(String[] args) {
		
		// '������'�� ������ ��ǰ ����Ʈ
		ProductVO[] proMJH = {
				new ProductVO("KENZO", 35, 1),
				new ProductVO("BOSS", 25, 1),
				new ProductVO("Columbia", 55, 1),
				new ProductVO("Adidas", 5, 2)
		};
		
		// '������'�� ������ ��ǰ ����Ʈ
		ProductVO[] proLTH = {
			new ProductVO("Lacoste", 20, 3),
			new ProductVO("Beanpole", 15, 1)
		};
		
		// '�̿���'�� ������ ��ǰ ����Ʈ
		ProductVO[] proLYW= {
			new ProductVO("Nike", 10, 2),
			new ProductVO("Puma", 15, 2),
			new ProductVO("Moschino", 60, 1)
		};
		
		// '�����'�� ������ ��ǰ ����Ʈ
		ProductVO[] proKWJ = {
			new ProductVO("Lush", 5, 10),
			new ProductVO("Metrocity", 15, 1),
			new ProductVO("Moschino", 20, 1),
			new ProductVO("Givenchy", 55, 1),
			new ProductVO("Vans", 10, 3),
		};		
		
		// �� ���� �� ����Ʈ
		CustomerVO cusLTH = new CustomerVO("������", proMJH, 0);
		CustomerVO cusMJH = new CustomerVO("������", proLTH, 0);
		CustomerVO cusLYW = new CustomerVO("�̿���", proLYW, 0);
		CustomerVO cusKWJ = new CustomerVO("�����", proKWJ, 0);
		
		CustomerVO[] customerList = {cusLTH, cusMJH, cusLYW, cusKWJ};
		
		
		// MarketSystemService ��ü ����
		MarketSystemService kosta = new MarketSystemService();

		//-------------------------------------------��ü  ���� �� �ʱ�ȭ ����-------------------------------------------
		
		//�� ����Ʈ ���
		kosta.printAllCustomer(customerList);
		System.out.println("\n");
		
		//��ǰ ����Ʈ ���
		kosta.printAllProduct(proKWJ);
		System.out.println("\n");
		
		//���� �� ��ǰ �߿��� 50���� �̻��� ��ǰ ���
		kosta.printProductAbove50(cusKWJ);
		System.out.println("\n");
		
		// ��ǰ ����Ʈ�� ���ڷ� �޾� ��ǰ���� �� ���� ���
		kosta.printTotalPrice(proKWJ);
		System.out.println("\n");
		
	}

}
		


