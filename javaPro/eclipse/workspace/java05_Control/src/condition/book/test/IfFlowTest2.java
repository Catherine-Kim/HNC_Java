package condition.book.test;

import java.util.Scanner;

/*
 * page 140, ���� 4-3
 * ����ڿ��� �Է¹��� ���� 0���� �ƴ��� �˷��ֱ�(w/ if-else)
 * �Ӹ��� ������ �������� ������ �� �ڵ��غ���
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
