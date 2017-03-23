package step3.test;

public class StringBufferTest {
	public static void main(String[] args) {
		String str = new String("This is ");
		str.concat("Test");
		System.out.println("str.concat(\"Test\")의 결과 : " + str);
		
		StringBuffer sb = new StringBuffer("This is ");
		sb.append("Test");
		System.out.println("\nStringBuffer 클래스 sb.append(\"Test\")의 결과 : " + sb);
		
		System.out.println("\nStringBuffer 클래스 sb.insert(8, \"StringBuffer \")의 결과 : " 
								+ sb.insert(8, "StringBuffer "));
		System.out.println("\nStringBuffer 클래스 sb.reverse()의 결과 : " + sb.reverse());
		
		sb.setCharAt(0, '!');
		System.out.println("\nStringBuffer 클래스 sb.setCharAt(0, '!')의 결과 : " + sb);
		
		String strr = sb.toString();
		System.out.println("\nStringBuffer 클래스 sb.toString()의 결과 : " + strr);
	}
}
