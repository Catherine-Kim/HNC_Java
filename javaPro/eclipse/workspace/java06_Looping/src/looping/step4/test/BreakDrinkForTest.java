package looping.step4.test;

public class BreakDrinkForTest {
	
	public void goHome(){
		System.out.println("I'm leaving home...");
	}
	
	public static void main(String[] args) {
		BreakDrinkForTest b = new BreakDrinkForTest();
		for(int beer = 1; beer <= 50; beer++){
			System.out.println("Beer " + beer + "...");
			if(beer == 15){
				b.goHome();
				break;
			}
		}
	}
}

