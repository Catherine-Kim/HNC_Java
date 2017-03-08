package looping.step4.test;

import java.util.Scanner;

public class LoopingWithScannerTest {
	public static void main(String[] args){
		boolean run = true;			// ���� ���θ� ǥ���ϴ� ����
		int balance = 0;			// �ܾ�
		int amount = 0;
		int menuNo = 0;
		
		// run�� balance�� ���� �����̱� ������ �ݵ�� �ʱ�ȭ�������
		
		Scanner sc = new Scanner(System.in);
		
		while(run){
			System.out.println("--------------------------------------");
			System.out.println("1. ����  |  2. ���  |  3. �ܾ���ȸ  |  4. ���α׷� ����");
			System.out.print("���ϴ� ���񽺸� �����ּ���. > ");
			
			menuNo = sc.nextInt();
			
			switch(menuNo){
			case 1 :
				System.out.print("�����ϰ��� �ϴ� �ݾ��� �Է����ּ���. > ");
				amount = sc.nextInt();
				System.out.println("������ �õ��ϴ� ��...");
				balance += amount;
				System.out.println(amount + "�� ������ ���������� ���ƽ��ϴ�.");
				break;
			case 2 :
				System.out.print("����ϰ��� �ϴ� �ݾ��� �Է����ּ���. > ");
				amount = sc.nextInt();
				System.out.println("����� �õ��ϴ� ��...");
				while(balance < amount){
					System.out.print("�ܾ��� �����մϴ�. ��� �ݾ��� �ٽ� �Է����ּ���. > ");
					amount = sc.nextInt();
				}
				balance -= amount;
				System.out.println(amount + "�� ����� ���������� ���ƽ��ϴ�.");
				break;
			case 3 :
				System.out.println("�ʴ��� �ܾ��� " + balance + "���Դϴ�.");
				break;
			case 4 : 
				System.out.println("���α׷��� �����մϴ�");
				run = false;
				break;				
			default :
				System.out.println("�߸��� �Է��Դϴ�. ���Ͻô� ���񽺸� �ٽ� �����ּ���.");
			} // switch
		} // while
	} // main
} // class