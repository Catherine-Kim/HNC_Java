package userexception.step1.test;

class Customer{
	public void add(int i, int j) throws ArithmeticException{
		if(j == 0){
			System.out.println("1. Created a bomb");
			System.out.println("2. Threw the bomb");
			throw new ArithmeticException();
		}
		// j�� �и�� �ϴ� ������ ���´�....ġ��
	}
}

public class UserExceptionTest1 {
	public static void main(String[] args) {
		Customer c = new Customer();
		try{
			c.add(10, 0);
		}catch(ArithmeticException e){
			System.out.println("3. Handled the bomb");
		}
	}
}
