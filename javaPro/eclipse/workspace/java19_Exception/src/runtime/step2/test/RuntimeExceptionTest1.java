package runtime.step2.test;

public class RuntimeExceptionTest1 {
	public static void main(String[] args) {
		System.out.println("**************NullPointerException**************");
		
		String str = new String("KOSTA");
		String str1 = new String("KOSTA");

		System.out.println(str.hashCode());
		System.out.println(str1.hashCode());
	}
}
