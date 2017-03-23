package step4.self;

import java.util.StringTokenizer;

public class StringProb2 {
	public static void main(String[] args) {
		System.out.println(spaceTrim("Java  Program        Language"));
		System.out.println(spaceTrim("Structured Query     Language"));
		System.out.println(spaceTrim("Servlet & JSP"));
	}

	private static char[] spaceTrim(String string) {
		// StringTokenizer는 " "가 여러 개여도 하나로 인식하니까 split() 대신에 StringTokenizer 클래스 사용
		StringTokenizer stk = new StringTokenizer(string, " ");
		
		int count = 0;						// 인자로 받은 string에서 공백을 제외한 char 개수 구하기
		for(int j = 0; j < string.length(); j++){
			if(string.charAt(j) != ' ')	
				count++;
		}
		
		// 결과값 담을 char[] 생성 : size는 공백 아닌 char 개수(count) + 공백 개수(token 개수 - 1)
		char[] result = new char[stk.countTokens() + count - 1];
		int charIndex = 0;
		
		while(stk.hasMoreTokens()){
			String tmp = stk.nextToken();

			for (int i = 0; i < tmp.length(); i++) {	
				result[charIndex] = tmp.charAt(i);		// 각 token의 char를 차례로 result에 담음
				charIndex++;		// i는 각 token의 char을 가리키는 index, charIndex는 result의 index
			}
			if (stk.hasMoreTokens() != false) {		// 각 token의 끝에 ' ' 넣어서 공백 만들어주기
				result[charIndex] = ' ';			// 마지막 token이면 마지막에 ' ' 안 붙임
				charIndex++;
			}
		}
		
		return result;
	}
}
