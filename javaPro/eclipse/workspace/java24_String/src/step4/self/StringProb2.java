package step4.self;

import java.util.StringTokenizer;

public class StringProb2 {
	public static void main(String[] args) {
		System.out.println(spaceTrim("Java  Program        Language"));
		System.out.println(spaceTrim("Structured Query     Language"));
		System.out.println(spaceTrim("Servlet & JSP"));
	}

	private static char[] spaceTrim(String string) {
		// StringTokenizer�� " "�� ���� ������ �ϳ��� �ν��ϴϱ� split() ��ſ� StringTokenizer Ŭ���� ���
		StringTokenizer stk = new StringTokenizer(string, " ");
		
		int count = 0;						// ���ڷ� ���� string���� ������ ������ char ���� ���ϱ�
		for(int j = 0; j < string.length(); j++){
			if(string.charAt(j) != ' ')	
				count++;
		}
		
		// ����� ���� char[] ���� : size�� ���� �ƴ� char ����(count) + ���� ����(token ���� - 1)
		char[] result = new char[stk.countTokens() + count - 1];
		int charIndex = 0;
		
		while(stk.hasMoreTokens()){
			String tmp = stk.nextToken();

			for (int i = 0; i < tmp.length(); i++) {	
				result[charIndex] = tmp.charAt(i);		// �� token�� char�� ���ʷ� result�� ����
				charIndex++;		// i�� �� token�� char�� ����Ű�� index, charIndex�� result�� index
			}
			if (stk.hasMoreTokens() != false) {		// �� token�� ���� ' ' �־ ���� ������ֱ�
				result[charIndex] = ' ';			// ������ token�̸� �������� ' ' �� ����
				charIndex++;
			}
		}
		
		return result;
	}
}
