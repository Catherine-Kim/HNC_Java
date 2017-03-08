package condition.step1.test;

import java.util.Scanner;

/*
 * score에 따라 grade가 나눠지는 로직을 이전에는 if문으로 작성했다.
 * (if/else if/else)
 * 이번에는 동일한 제어문 중에서 switch 문법으로 로직을 작성해보겠다.
 * (switch/case/break/default)
 */
public class GradeSwitchTest1 {

	public static void main(String[] args) {
		int score;
		char grade;
		
		System.out.println("Input your score : ");
		
		Scanner sc = new Scanner(System.in);
		score = sc.nextInt();
		
		switch(score/10){
		case 10 :
			grade = 'A';
			break;
		case 9 : 
			grade = 'A';
			break;
		case 8 :
			grade = 'B';
			break;
		case 7 :
			grade = 'C';
			break;
		case 6 :
			grade = 'D';
			break;
		default :
			grade = 'F';
			break;
		}
		
		System.out.println("Your grade is " + grade);
	}
}
