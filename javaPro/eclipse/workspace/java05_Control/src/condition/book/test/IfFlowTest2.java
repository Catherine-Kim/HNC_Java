package condition.book.test;

import java.util.Scanner;

/*
 * page 140, 예제 4-3
 * 사용자에게 입력받은 값이 0인지 아닌지 알려주기(w/ if-else)
 * 머리로 컴파일 실행결과를 예측한 후 코딩해보자
 */

public class IfFlowTest2 {

	public static void main(String[] args) {
		int input;
		
		System.out.println("Please input any number : ");
		
		Scanner sc = new Scanner(System.in);
		input = sc.nextInt();
		
		if(input == 0)
			System.out.println("The number is 0.");
		else
			System.out.println("The number is not 0.");
	}

}
