package runtime.step3.test;

class Account{
	int balance;
	
	public void withdraw(int money) throws ArithmeticException{
		if(balance/money == 0)
			System.out.println("money�� 0�̸� �� �ȴٴ�");
	}
}

class Customer{
	String name;

	public void add(int age, int count) throws ArithmeticException{
		if(age/count == 0)
			
			System.out.println("��ź�� �����ڵ�?");	// ���� �߻� �� ��� �� ��
	}
	
	public void infoName() throws NullPointerException{
		name.length();		// ���� ���� ����
	}
}

public class ExceptionThrowsTest1 {
	public static void main(String[] args) {
		Customer cust = new Customer();
		Account acc = new Account();
		
		try{
			acc.withdraw(0);
		}catch(ArithmeticException e){
			System.out.println("money�� 0�̸� �� �ȴٱԿ�");
		}
		
		try{
			cust.add(10, 0);
			System.out.println("ArithmeticException ��ź�� �Ϸ� ����ò���!");
			System.out.println("���⼭ ��ź ó���҄�!");
		}catch(ArithmeticException e){
			System.out.println("ArithmeticException ��ź ó�� ���� ������!");
		}
		
		try{
			cust.infoName();
			System.out.println("NullPointerException ��ź�� �Ϸ� ����ò���!");
			System.out.println("���⼭ ��ź ó���҄�!");
		}catch(NullPointerException e){
			System.out.println("NullPointerException ��ź ó�� ���� ������!");
		}
	}
}
