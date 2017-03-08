package primitive.step3.test;

public class ChangeNumberArrayTest2 {
	public static void main(String[] args) {
		int[] number = new int[10];				// �⺻��(0)�� ����ִ� ������ �迭 ����
		
		System.out.println("Values of number[] before rearrangement ::");
		
		for(int i = 0; i < number.length; i++){	
			number[i] = i;
			System.out.println("number [" + i + "] : " + number[i]);
		}
		
		for(int i = 1; i < 8; i++){			// 100�� �׳� ����� ū ���� �� �ϳ��� �� ����
			int n = (int)(Math.random() * 9);	// 0 ~ 9 ������ ������ ���� �Ҵ�
			int tmp = number[0];				// �� �� �� ������ ���� swap�ϱ� ���� �Ͻ������� �ϳ��� ���� ��Ƶα� ���� ����
			number[0] = number[n];
			number[n] = tmp;
		}
		
		System.out.println("\nValus of number[] after rearrangement ::");
		
		for(int i = 0; i < number.length; i++)
			System.out.println("number [" + i + "] : " + number[i]);
	}
}
