package runtime.step1.test;

public class RuntimeExceptionTest2 {
	public static void main(String[] args) {
		String[] str = {
				"Hello Exception",
				"No I mean it",
				"Have a good time"
		};
		
		try{
			for(int i = 0; i <= 3; i++){
				System.out.println(str[i]);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("The Exception is " + e);
		}finally{
			System.out.println("Something's just done.");
		}
	}
}


