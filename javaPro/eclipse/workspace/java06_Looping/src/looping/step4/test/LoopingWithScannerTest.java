package looping.step4.test;

import java.util.Scanner;

public class LoopingWithScannerTest {
	public static void main(String[] args){
		boolean run = true;			// 실행 여부를 표시하는 변수
		int balance = 0;			// 잔액
		int amount = 0;
		int menuNo = 0;
		
		// run과 balance는 로컬 변수이기 때문에 반드시 초기화해줘야함
		
		Scanner sc = new Scanner(System.in);
		
		while(run){
			System.out.println("--------------------------------------");
			System.out.println("1. 예금  |  2. 출금  |  3. 잔액조회  |  4. 프로그램 종료");
			System.out.print("원하는 서비스를 눌러주세요. > ");
			
			menuNo = sc.nextInt();
			
			switch(menuNo){
			case 1 :
				System.out.print("예금하고자 하는 금액을 입력해주세요. > ");
				amount = sc.nextInt();
				System.out.println("예금을 시도하는 중...");
				balance += amount;
				System.out.println(amount + "원 예금을 성공적으로 마쳤습니다.");
				break;
			case 2 :
				System.out.print("출금하고자 하는 금액을 입력해주세요. > ");
				amount = sc.nextInt();
				System.out.println("출금을 시도하는 중...");
				while(balance < amount){
					System.out.print("잔액이 부족합니다. 출금 금액을 다시 입력해주세요. > ");
					amount = sc.nextInt();
				}
				balance -= amount;
				System.out.println(amount + "원 출금을 성공적으로 마쳤습니다.");
				break;
			case 3 :
				System.out.println("너님의 잔액은 " + balance + "원입니다.");
				break;
			case 4 : 
				System.out.println("프로그램을 종료합니다");
				run = false;
				break;				
			default :
				System.out.println("잘못된 입력입니다. 원하시는 서비스를 다시 눌러주세요.");
			} // switch
		} // while
	} // main
} // class