package runtime.step2.test;

public class RuntimeExceptionTest2 {
	public static void main(String[] args) {
		System.out.println("**************Multiple Catch**************");
		
		String str = new String("KOSTA"); 	// ���� str�� �ּҰ� �������(��������)
		str = null;		// ������ ������
		
		try{
			System.out.println(str.length());
		}catch(ArithmeticException | NullPointerException a){
			System.out.println("1. ArithmeticException catch...");
		}finally{
			System.out.println("Something's done anyway");
		}
	}
}
