package primitive.step1.test;

public class IntArrayTest1 {
	public static void main(String[] args){
		int[] array = new int[3];				// integer Ÿ���� �迭 'array' ����, ����
		int i;
		
		System.out.print("The array is located in " + array + ", and the array has ");
		// array�� �ּҰ� ���� ���
		
		for(i = 0; i < array.length; i++){				// �ݺ����� �̿��Ͽ� �迭 'array' �� �� �Ҵ�
			array[i] = (int)(Math.random() * 40 + 1);	// 1 ~ 40 ������ ������ ���� �Ҵ�
			if(i < 2)
				System.out.print(array[i] + " in array[" + i + "], ");	// 'array'���� ���� ���
			else
				System.out.print(array[i] + " in array[" + i + "].");
		}
	}
}

