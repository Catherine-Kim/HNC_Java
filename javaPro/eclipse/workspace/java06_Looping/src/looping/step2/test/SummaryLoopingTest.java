package looping.step2.test;

public class SummaryLoopingTest {
	public static void main(String[] args){
		int i;
		int sum = 0;
		
		for(i = 1; i <= 10; i++){			// for ver.
			sum += i;
			System.out.print(i);
			if(i != 10)
				System.out.print(" + ");
		}
		System.out.println(" = " + sum);
		
		i = 1;
		sum = 0;
		
		while(i <= 10){						// while ver.
			sum += i;
			System.out.print(i);
			if(i != 10)
				System.out.print(" + ");
			i++;
		}
		System.out.println(" = " + sum);
	}
}
