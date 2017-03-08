package primitive.step4.test;

public class ArrayCopyTest2 {

	public static void main(String[] args) {
		int[] target = {1, 2, 3, 4, 5, 6 , 7, 8, 9, 10};	// length == 10
		int[] source = {99, 88, 77, 66, 55, 44, 33};		// length == 7'
		
		System.arraycopy(source, 0, target, 4, 6);	// System.arraycopy(src, srcPos, dest, destPos, length);
		
		for(int i = 0; i < target.length; i++)
			System.out.println("target[" + i + "] : " + target[i]);
	}
}
