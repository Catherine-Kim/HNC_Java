package looping.step3.test;

public class DoubleForTest {
	public static void main(String[] args) {
		int i;
		int j;
		
		for(i = 0; i < 3; i++){
			for(j = 1; j <= 5; j++){
				if(j == 5)
					System.out.println(j + "\t");
				else
					System.out.print(j + "\t");
			}
		}
	}
}
