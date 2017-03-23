package step4.self;

public class StringProb1 {
	public static void main(String[] args) {
		System.out.println(makeInitial("Java Data Base Conectivity"));
		System.out.println(makeInitial("Java Server Pages"));
		System.out.println(makeInitial("Enterprise Java Beans"));
	}

	private static String makeInitial(String fullName) {
		String result = "";				// ����� ���� ����
		String[] afterSplit = fullName.split(" ");	// ���ڷ� ���� String�� " "�� �������� split
		for(String s : afterSplit){					
			result += s.charAt(0);	// split�� String���� ���� ù char�� ��� ������ �ϳ��� ����
		}	
		return result;
	}
}
