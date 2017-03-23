package step4.self;

public class StringProb1 {
	public static void main(String[] args) {
		System.out.println(makeInitial("Java Data Base Conectivity"));
		System.out.println(makeInitial("Java Server Pages"));
		System.out.println(makeInitial("Enterprise Java Beans"));
	}

	private static String makeInitial(String fullName) {
		String result = "";				// 결과를 담을 변수
		String[] afterSplit = fullName.split(" ");	// 인자로 받은 String을 " "을 기준으로 split
		for(String s : afterSplit){					
			result += s.charAt(0);	// split한 String들의 제일 첫 char를 결과 변수에 하나씩 더함
		}	
		return result;
	}
}
