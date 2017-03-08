package condition.step1.test;

 //주사위 눈금이 나오도록 해보자

public class SwitchDiceTest3 {
	public static void main(String[] args) {
		int dice = (int)(Math.random()*6+1);
		
		System.out.println(dice);
		
		switch(dice){
		case 1:
		case 3:
		case 5:
			System.out.println("이건 홀수");
			break;
		case 2:
		case 4:
		case 6:
			System.out.println("이건 짝수");
			break;
		default :
			System.out.println("잘못된 값임");
			
		}
	}
}
