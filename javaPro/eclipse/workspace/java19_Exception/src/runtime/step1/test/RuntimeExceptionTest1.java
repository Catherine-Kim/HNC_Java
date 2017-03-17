package runtime.step1.test;

public class RuntimeExceptionTest1 {
	public static void main(String[] args) {
		String[] str = {
				"Hello Exception",
				"No I mean it",
				"Have a good time"
		};
		
		for(int i = 0; i < 3; i++){
			System.out.println(str[i]);
		}
		
		int i = 0;
		int j = 10;
		
		if((i/j) == 0)
			System.out.println("±ÂÀâ...");
	}
	
}


