package condition.book.test;

import java.util.Scanner;

/*
 * page 138, ���� 4-2
 * ����ڿ��� �Է¹��� ���� 0���� �ƴ��� �˷��ֱ�(w/ if)
 * �Ӹ��� ������ �������� ������ �� �ڵ��غ���
 */

public class IfFlowTest1 {

	public static void main(String[] args) {
		int input;
		
		System.out.println("Please input any number : ");
		
		Scanner sc = new Scanner(System.in);
		input = sc.nextInt();
		
		if(input == 0)
			System.out.println("The number is 0.");
		if(input != 0)
			System.out.println("The number is not 0.");
	}

}
