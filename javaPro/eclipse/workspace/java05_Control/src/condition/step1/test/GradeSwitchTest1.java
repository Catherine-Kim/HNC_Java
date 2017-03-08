package condition.step1.test;

import java.util.Scanner;

/*
 * score�� ���� grade�� �������� ������ �������� if������ �ۼ��ߴ�.
 * (if/else if/else)
 * �̹����� ������ ��� �߿��� switch �������� ������ �ۼ��غ��ڴ�.
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
