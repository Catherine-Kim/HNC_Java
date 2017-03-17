package compile.step2.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileExceptionTest3{
	public static void main(String[] args) throws IOException{
		String fileName = "src\\adele.txt";
		FileReader fr = null;
		
		System.out.println("Creating FileReader...");
		fr = new FileReader(fileName);
		fr.read();
		fr.close();
	}
}

