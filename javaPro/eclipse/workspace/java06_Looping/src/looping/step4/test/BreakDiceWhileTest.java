package looping.step4.test;

public class BreakDiceWhileTest {
	public static void main(String[] args) {
		int dice = 0;
		int count = 1;
		while(true){
			dice = (int)(Math.random()*6+1);
			System.out.println("The dice is " + dice + " : " + count + "ȸ");
			if(dice == 6)
				break;
			count++;
		}
		System.out.println(count + " times done :: Now we end the loop.");
	}
}
