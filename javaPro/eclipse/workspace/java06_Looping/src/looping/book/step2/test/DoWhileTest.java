package looping.book.step2.test;		// p.173 ���� 4-28

import java.util.Scanner;

public class DoWhileTest {
	public static void main(String[] args){
		int input = 0;
		int ran = (int)(Math.random() * 10 + 1);
		
	
		do{
			System.out.println("���ڸ� �Է��Ͻÿ�.");
			Scanner sc = new Scanner(System.in);
			input = sc.nextInt();
		
			if(ran > input)
				System.out.println("�� ���� ������");
			else if(ran < input)
				System.out.println("�� ���� ������");
			else
				break;
		}while(input != ran);
	
		System.out.println("Correct!");
	}

}
