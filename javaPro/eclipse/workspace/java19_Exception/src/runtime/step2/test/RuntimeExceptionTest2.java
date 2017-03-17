package runtime.step2.test;

public class RuntimeExceptionTest2 {
	public static void main(String[] args) {
		System.out.println("**************Multiple Catch**************");
		
		String str = new String("KOSTA"); 	// 현재 str에 주소값 들어있음(참조변수)
		str = null;		// 참조가 끊어짐
		
		try{
			System.out.println(str.length());
		}catch(ArithmeticException | NullPointerException a){
			System.out.println("1. ArithmeticException catch...");
		}finally{
			System.out.println("Something's done anyway");
		}
	}
}
