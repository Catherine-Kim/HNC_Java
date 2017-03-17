package book.test.p418;

public class ExceptionEx3 {
	public static void main(String[] args) {
		int result = 0;
		int number = 100;
		
		for(int i = 0; i < 20; i++){
			try{
				result = number / (int)(Math.random() * 10);
				System.out.println(result);
			}catch(ArithmeticException ae){
				System.out.println("Arithmetic Exception occured");
			}
		}
	}
}
