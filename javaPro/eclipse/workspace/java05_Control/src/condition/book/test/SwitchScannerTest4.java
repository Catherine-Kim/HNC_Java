package condition.book.test;

import java.util.Scanner;

/*
 * page 152, ���� 4-8
 * ����ڿ��� �Է¹��� �ֹι�ȣ�� ������� ���� ����
 */

public class SwitchScannerTest4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String serialNo = sc.nextLine();
		char gender;
		String str;
		
		gender = serialNo.charAt(6);
		
		switch(gender){
		case '1':
		case '3':
			str = "����";
			break;
		case '2':
		case '4':
			str = "����";
			break;
		default:
			str = "�ܱ��� �ƴϸ� �ܰ���";
			break;
		}
		
		System.out.println("����� " + str + "�Դϴ�.");
	}
}
