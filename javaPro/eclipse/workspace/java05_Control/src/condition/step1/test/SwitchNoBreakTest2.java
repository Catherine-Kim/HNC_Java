package condition.step1.test;

public class SwitchNoBreakTest2 {
	public static void main(String[] args) {
		// random() : 0~1 사이의 실수를 임의적으로 리턴하는 함수
		int time = (int)(Math.random() * 4 + 8); // 1 ~ 10 사이의 임의의 정수 고르기 
		System.out.println("현재 시간 : " + time + "시");
		switch(time){
		case 8:
			System.out.println("출근을 합니다.");
		case 9:
			System.out.println("오전 회의를 합니다");
		case 10:
			System.out.println("업무를 봅니다.");
		case 11:
			System.out.println("외근을 나갑니다.");
		}
	}
}
