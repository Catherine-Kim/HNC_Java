package looping.step1.test;

public class BasicLoopTest {
	public static void main(String[] args) {
		int i;
		int count = 1;
		
		System.out.println("For문 실습 ::");
		for(i = 0; i < 10; i++){
			System.out.println("Hellooooooooooooooooooooooooo " + count + "회");
			count++;
		}
		System.out.println("\n");
		
		System.out.println("While 문 실습 ::");
		count = 1;
		while(i > 0){
			System.out.println("Hellooooooooooooooooooooooooo " + count + "회");
			i--;
			count++;
		}
		System.out.println("\n");
		
		System.out.println("Do ~ While 문 실습 ::");
		count = 1;
		do{
			System.out.println("Hellooooooooooooooooooooooooo " + count + "회");
			i++;
			count++;
		}while(i<10);
		System.out.println("\n");
	}
}
