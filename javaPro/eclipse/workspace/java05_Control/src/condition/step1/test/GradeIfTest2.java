package condition.step1.test;

/* 
 * �л����� ������ ���� ����� ����ϴ� ���α׷��� �ۼ�
 * if ���ǹ��� ���� ������ ������ �� �ִ�.
 */

public class GradeIfTest2 {
	public static void main(String[] args){
		//int score = 88;
		
		// ���� ������ �޴� ���ڰ��� ������ String Ÿ��

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
