package condition.book.test;

import java.util.Scanner;

/*
 * page 150, ���� 4-7
 * ����ڶ� ���Ͷ� ���������� �ؼ� ��� �˷��ֱ�
 */

public class SwitchScannerTest3 {
	public static void main(String[] args) {
		// ���� : 1, ���� : 2, �� : 3
		
		Scanner sc = new Scanner(System.in);
		int user = sc.nextInt();
		int com = (int)(Math.random()*3+1);
		String user_tmp = null;
		String com_tmp = null;
		
		if(user > 3 || user < 1)
			System.out.println("Wrong Input");
		else{
			if(user == 1) user_tmp = "����";
			if(user == 2) user_tmp = "����";
			if(user == 3) user_tmp = "��";
			
			if(com == 1) com_tmp = "����";
			if(com == 2) com_tmp = "����";
			if(com == 3) com_tmp = "��";
			
			System.out.println("User : " + user_tmp);
			System.out.println("Computer : " + com_tmp);
			
			if(user==com)
				System.out.println("Stalemate");
			else if((user-com)==1 || (user-com)==-2)
				System.out.println("You won");
			else
				System.out.println("Computer won");
		}
	}
}
