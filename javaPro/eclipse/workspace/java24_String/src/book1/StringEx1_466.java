package book1;

public class StringEx1_466 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		
		System.out.println("String str1 = \"abc\"");
		System.out.println("String str2 = \"abc\"");
		
		System.out.println("str1 == str2 :: " + (str1 == str2));
		System.out.println("str1.equals(str2) :: " + (str1.equals(str2)));
		
		String str3 = new String("abc");
		String str4 = new String("abc");
		
		System.out.println("\nString str3 = new String(\"abc\")");
		System.out.println("String str4 = new String(\"abc\")");
		
		System.out.println("str1 == str2 :: " + (str3 == str4));	// 주소 비교가 되는 거임
		System.out.println("str1.equals(str2) :: " + (str3.equals(str4)));
		
		System.out.println("\nstr1 == str3 :: " + (str1 == str3));	
		System.out.println("str1.equals(str3) :: " + (str1.equals(str3)));
	}
}
