package condition.step1.test;

import java.util.Scanner;

/* 
 * Scanner 객체를 생성
 * 콘솔창에서 값을 입력해서 로직을 작성하도록 함
 */

public class GradeIfTest3 {
	public static void main(String[] args){
		
		System.out.println("Input your score : ");
		Scanner sc = new Scanner(System.in);
		//String stringScore = sc.nextLine();
		//int score = Integer.parseInt(stringScore);
		int score = sc.nextInt();
		
		if(score >= 90)
			System.out.println("A");
		else if(score >= 80 && score < 90)
			System.out.println("B");
		else if(score >= 70 && score < 80)
			System.out.println("C");
		else
			System.out.println("Try again");
		
		
	}
}
