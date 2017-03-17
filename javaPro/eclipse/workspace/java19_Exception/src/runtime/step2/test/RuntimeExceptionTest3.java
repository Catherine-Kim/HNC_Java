package runtime.step2.test;

public class RuntimeExceptionTest3 {
	public static void main(String[] args) {
		System.out.println("**************NullPointerException**************");
		
		String str = new String("KOSTA"); 	// 현재 str에 주소값 들어있음(참조변수)
		str = null;		// 참조가 끊어짐
		
		try{
			System.out.println(str.length());
		}catch(ArithmeticException a){
			System.out.println("1. ArithmeticException catch...");
		}catch(NullPointerException n){
			System.out.println("2. NullPointerException catch...");
		}catch(ArrayIndexOutOfBoundsException a){
			System.out.println("3. ArrayIndexOutOfBoundsException catch...");
		}catch(Exception e){
			System.out.println("4. Exception catch...");
		}finally{
			System.out.println("Something's done anyway");
		}
	}
}
