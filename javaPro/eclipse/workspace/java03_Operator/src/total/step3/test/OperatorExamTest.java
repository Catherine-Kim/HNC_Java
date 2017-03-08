package total.step3.test;

// Simple Operator Code

public class OperatorExamTest {

	public static void main(String[] args) {
		// Variable Declaration
		// field�� Ŭ���� �ȿ� ����Ǿ� ����
		// ���� ������ �޼ҵ� �ȿ����� �ϱ� ������ �� ������ �ش� �޼ҵ� �ȿ����� �� �� ����
		// �޼ҵ� �ȿ��� ����� ���� : Local Variable(���� ����)
		// field�ʹ� ������ �ٸ��� -> ������ ����� ��ġ�� ���� �߿�
		
		int i = 5; 
		int j = 3;
		
		System.out.println("i%j : " + i%j);
		
		// Operator�� �����ؼ� �� ���� �޼ҵ带 ���� �;�
		// ��ü ���� ��
		
		Operator o = new Operator();
		Operator o2 = new Operator();
		
		// o�� o2�� �ٸ� ��ü -> ���� �ٸ� �ּҰ��� ����
		
		System.out.println("o�� �ּҰ� : " + o);
		System.out.println("o2�� �ּҰ� : " + o2);
		System.out.println("o==o2 : " + (o==o2));
		
		// �ּҰ��� �ٸ��ٸ� ���� �ٸ� ��ü���� Ȯ���� �� ����
		
		o = o2;
		// o�� �ּҰ� == o2�� �ּҰ�
		
		System.out.println("o = o2 �� �� �� ::");
		
		System.out.println("o�� �ּҰ� : " + o);
		System.out.println("o2�� �ּҰ� : " + o2);
		System.out.println("o==o2 : " + (o==o2));
		
		boolean flag = false;
		
		System.out.println(flag);
		System.out.println(!flag);
		
		int k = 10;
		
		System.out.println(k++);
		System.out.println(k);
		
		int m = 10;
		
		System.out.println(++m);
		
		int balance = 10000;
		balance -= 5000;
		System.out.println(balance);
		
		System.out.println(o.test1() && o.test2());
	}

}

class Operator{
	public boolean test1(){
		System.out.println("test1() calling...");
		return true;
	}
	
	public boolean test2(){
		System.out.println("test2() calling...");
		return false;
	}
}