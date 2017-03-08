package looping.book.step2.test;		// p.173 예제 4-28

import java.util.Scanner;

public class DoWhileTest {
	public static void main(String[] args){
		int input = 0;
		int ran = (int)(Math.random() * 10 + 1);
		
	
		do{
			System.out.println("숫자를 입력하시오.");
			Scanner sc = new Scanner(System.in);
			input = sc.nextInt();
		
			if(ran > input)
				System.out.println("더 높은 숫자임");
			else if(ran < input)
				System.out.println("더 낮은 숫자임");
			else
				break;
		}while(input != ran);
	
		System.out.println("Correct!");
	}

}
