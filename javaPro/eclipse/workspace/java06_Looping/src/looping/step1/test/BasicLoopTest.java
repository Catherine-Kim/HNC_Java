package looping.step1.test;

public class BasicLoopTest {
	public static void main(String[] args) {
		int i;
		int count = 1;
		
		System.out.println("For�� �ǽ� ::");
		for(i = 0; i < 10; i++){
			System.out.println("Hellooooooooooooooooooooooooo " + count + "ȸ");
			count++;
		}
		System.out.println("\n");
		
		System.out.println("While �� �ǽ� ::");
		count = 1;
		while(i > 0){
			System.out.println("Hellooooooooooooooooooooooooo " + count + "ȸ");
			i--;
			count++;
		}
		System.out.println("\n");
		
		System.out.println("Do ~ While �� �ǽ� ::");
		count = 1;
		do{
			System.out.println("Hellooooooooooooooooooooooooo " + count + "ȸ");
			i++;
			count++;
		}while(i<10);
		System.out.println("\n");
	}
}
