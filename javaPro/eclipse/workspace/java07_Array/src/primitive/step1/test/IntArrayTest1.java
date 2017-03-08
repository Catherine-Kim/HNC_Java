package primitive.step1.test;

public class IntArrayTest1 {
	public static void main(String[] args){
		int[] array = new int[3];				// integer 타입의 배열 'array' 선언, 생성
		int i;
		
		System.out.print("The array is located in " + array + ", and the array has ");
		// array의 주소값 먼저 출력
		
		for(i = 0; i < array.length; i++){				// 반복문을 이용하여 배열 'array' 내 값 할당
			array[i] = (int)(Math.random() * 40 + 1);	// 1 ~ 40 사이의 임의의 수로 할당
			if(i < 2)
				System.out.print(array[i] + " in array[" + i + "], ");	// 'array'내의 값들 출력
			else
				System.out.print(array[i] + " in array[" + i + "].");
		}
	}
}

