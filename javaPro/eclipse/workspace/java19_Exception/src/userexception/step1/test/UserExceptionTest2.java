package userexception.step1.test;

class Customer2{
	public void add(int i, int j) throws ArithmeticException{
		if(j == 0){
			System.out.println("1. Created a bomb");
			System.out.println("2. Threw the bomb");
			throw new ArithmeticException();
		}
		// j를 분모로 하는 로직이 나온다....치자
	}
}

public class UserExceptionTest2 {
	public static void main(String[] args) {
		Customer2 c = new Customer2();
		try{
			c.add(10, 0);
		}catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}
	}
}
