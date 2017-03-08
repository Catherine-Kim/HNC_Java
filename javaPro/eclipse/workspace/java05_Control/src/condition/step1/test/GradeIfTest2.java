package condition.step1.test;

/* 
 * 학생들의 성적에 따라 등급을 출력하는 프로그램을 작성
 * if 조건문에 대한 문법을 정리할 수 있다.
 */

public class GradeIfTest2 {
	public static void main(String[] args){
		//int score = 88;
		
		// 실행 시점에 받는 인자값은 무조건 String 타입

		int score = Integer.parseInt(args[0]);
		
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
