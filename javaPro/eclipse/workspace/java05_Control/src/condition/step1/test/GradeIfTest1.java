package condition.step1.test;

/* 
 * �л����� ������ ���� ����� ����ϴ� ���α׷��� �ۼ�
 * if ���ǹ��� ���� ������ ������ �� �ִ�.
 */

public class GradeIfTest1 {
	public static void main(String[] args){
		int score = 88;
		
		/*
		if(score >= 90){
			System.out.println("A");
		}else if(score >= 80 && score < 90){
			System.out.println("B");
		}else if(score >= 70 && score < 80){
			System.out.println("C");
		}else{
			System.out.println("Try again");
		}
		*/
		
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
