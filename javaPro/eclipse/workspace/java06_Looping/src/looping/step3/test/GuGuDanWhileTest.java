package looping.step3.test;					
// 이중 for문을 이용해서 구구단을 출력해보자

public class GuGuDanWhileTest {
	public static void main(String[] args) {
		int i = 1;
		int j;
		
		while(i <= 9){
			j = 1;
			while(j <= 9){
				System.out.println(i + " x " + j + " = " + (i * j));
				j++;
			}
			i++;
			System.out.println("\n");
		}
	}
}
