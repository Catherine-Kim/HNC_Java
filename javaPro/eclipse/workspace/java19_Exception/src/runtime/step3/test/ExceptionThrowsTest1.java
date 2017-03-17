package runtime.step3.test;

class Account{
	int balance;
	
	public void withdraw(int money) throws ArithmeticException{
		if(balance/money == 0)
			System.out.println("money°¡ 0ÀÌ¸é ¾È µÈ´Ù´É");
	}
}

class Customer{
	String name;

	public void add(int age, int count) throws ArithmeticException{
		if(age/count == 0)
			
			System.out.println("ÆøÅºÀÌ ÅÍÁö°ÚµÍ?");	// ¿¡·¯ ¹ß»ý ½Ã Ãâ·Â ¾È µÊ
	}
	
	public void infoName() throws NullPointerException{
		name.length();		// °ªÀÌ ¾ø´Â »óÅÂ
	}
}

public class ExceptionThrowsTest1 {
	public static void main(String[] args) {
		Customer cust = new Customer();
		Account acc = new Account();
		
		try{
			acc.withdraw(0);
		}catch(ArithmeticException e){
			System.out.println("money°¡ 0ÀÌ¸é ¾È µÈ´Ù±Ô¿ô");
		}
		
		try{
			cust.add(10, 0);
			System.out.println("ArithmeticException ÆøÅºÀÌ ÀÏ·Î ³¯¶ó¿Ã²¨¾ä!");
			System.out.println("¿©±â¼­ ÆøÅº Ã³¸®ÇÒ„‚!");
		}catch(ArithmeticException e){
			System.out.println("ArithmeticException ÆøÅº Ã³¸® ¼º°ø ²ôÀ¸ÀÄ!");
		}
		
		try{
			cust.infoName();
			System.out.println("NullPointerException ÆøÅºÀÌ ÀÏ·Î ³¯¶ó¿Ã²¨¾ä!");
			System.out.println("¿©±â¼­ ÆøÅº Ã³¸®ÇÒ„‚!");
		}catch(NullPointerException e){
			System.out.println("NullPointerException ÆøÅº Ã³¸® ¼º°ø ²ôÀ¸ÀÄ!");
		}
	}
}
