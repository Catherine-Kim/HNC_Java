package looping.step3.test;					
// ���� for���� �̿��ؼ� �������� ����غ���

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
