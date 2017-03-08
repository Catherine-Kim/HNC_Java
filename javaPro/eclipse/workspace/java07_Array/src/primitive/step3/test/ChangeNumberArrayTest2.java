package primitive.step3.test;

public class ChangeNumberArrayTest2 {
	public static void main(String[] args) {
		int[] number = new int[10];				// 기본값(0)만 들어있는 상태의 배열 생성
		
		System.out.println("Values of number[] before rearrangement ::");
		
		for(int i = 0; i < number.length; i++){	
			number[i] = i;
			System.out.println("number [" + i + "] : " + number[i]);
		}
		
		for(int i = 1; i < 8; i++){			// 100은 그냥 충분히 큰 숫자 중 하나를 고른 거임
			int n = (int)(Math.random() * 9);	// 0 ~ 9 사이의 임의의 정수 할당
			int tmp = number[0];				// 두 개 의 변수의 값을 swap하기 위해 일시적으로 하나의 값을 담아두기 위한 변수
			number[0] = number[n];
			number[n] = tmp;
		}
		
		System.out.println("\nValus of number[] after rearrangement ::");
		
		for(int i = 0; i < number.length; i++)
			System.out.println("number [" + i + "] : " + number[i]);
	}
}
