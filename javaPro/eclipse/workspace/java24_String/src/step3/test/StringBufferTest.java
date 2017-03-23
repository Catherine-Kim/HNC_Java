package step3.test;

public class StringBufferTest {
	public static void main(String[] args) {
		String str = new String("This is ");
		str.concat("Test");
		System.out.println("str.concat(\"Test\")�� ��� : " + str);
		
		StringBuffer sb = new StringBuffer("This is ");
		sb.append("Test");
		System.out.println("\nStringBuffer Ŭ���� sb.append(\"Test\")�� ��� : " + sb);
		
		System.out.println("\nStringBuffer Ŭ���� sb.insert(8, \"StringBuffer \")�� ��� : " 
								+ sb.insert(8, "StringBuffer "));
		System.out.println("\nStringBuffer Ŭ���� sb.reverse()�� ��� : " + sb.reverse());
		
		sb.setCharAt(0, '!');
		System.out.println("\nStringBuffer Ŭ���� sb.setCharAt(0, '!')�� ��� : " + sb);
		
		String strr = sb.toString();
		System.out.println("\nStringBuffer Ŭ���� sb.toString()�� ��� : " + strr);
	}
}
