package condition.book.test;

import java.util.Scanner;

/*
 * page 152, 예제 4-8
 * 사용자에게 입력받은 주민번호로 사용자의 성별 저장
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
			str = "남자";
			break;
		case '2':
		case '4':
			str = "여자";
			break;
		default:
			str = "외국인 아니면 외계인";
			break;
		}
		
		System.out.println("당신은 " + str + "입니다.");
	}
}
