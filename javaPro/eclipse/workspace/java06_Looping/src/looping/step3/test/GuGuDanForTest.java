package looping.step3.test;					
// ���� for���� �̿��ؼ� �������� ����غ���

public class GuGuDanForTest {
	public static void main(String[] args) {
		int i;
		int j;
		
		for(i = 1; i <= 9; i++){
			for(j = 1; j <= 9; j++){
				System.out.println(i + " x " + j + " = " + (i * j));
			}
			System.out.println("\n");
		}
	}
}
