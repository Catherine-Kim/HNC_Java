package primitive.step4.test;

public class ResizingArrayTest1 {
	public static void main(String[] args){
		int[] i = new int[3];
		
		i[0] = 11;
		i[1] = 22;
		i[2] = 33;
		System.out.println("The address of the array 'i' : " + i);
		
		i = new int[7];
		
		// for���� ������ �迭 ���� ���� Ȯ��
		for(int j = 0; j < i.length; j++)
			System.out.print("i[" + j + "] : " + i[j] + " | ");
		
		System.out.println("The address of the array 'i' : " + i);
	}
}
