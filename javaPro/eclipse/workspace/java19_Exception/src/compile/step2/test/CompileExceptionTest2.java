package compile.step2.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileExceptionTest2{
	public static void main(String[] args) throws FileNotFoundException{
		String fileName = "src\\adele.txt";
		FileReader fr = null;
		
		try{
			System.out.println("1. Creating FileReader...");
			fr = new FileReader(fileName);
			fr.read();
		}catch(IOException e){
			
		}finally{
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}