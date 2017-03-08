package condition.book.test;

import java.util.Scanner;

/*
 * page 150, 예제 4-7
 * 사용자랑 컴터랑 가위바위보 해서 결과 알려주기
 */

public class SwitchScannerTest3 {
	public static void main(String[] args) {
		// 가위 : 1, 바위 : 2, 보 : 3
		
		Scanner sc = new Scanner(System.in);
		int user = sc.nextInt();
		int com = (int)(Math.random()*3+1);
		String user_tmp = null;
		String com_tmp = null;
		
		if(user > 3 || user < 1)
			System.out.println("Wrong Input");
		else{
			if(user == 1) user_tmp = "가위";
			if(user == 2) user_tmp = "바위";
			if(user == 3) user_tmp = "보";
			
			if(com == 1) com_tmp = "가위";
			if(com == 2) com_tmp = "바위";
			if(com == 3) com_tmp = "보";
			
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
