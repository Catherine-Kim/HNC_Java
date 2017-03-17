package compile.step2.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileExceptionTest1 {
	public static void main(String[] args) throws IOException {
		String fileName = "src\\adele.txt";
		FileReader fr = null;
		
		try{
			System.out.println("1. Creating FileReader...");
			fr = new FileReader(fileName);
			fr.read();
		}catch(FileNotFoundException e){
			
		}catch(IOException e){
			
		}
	}
}
