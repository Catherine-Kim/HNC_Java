package compile.step1.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading2{
	public void readFile(String fileName) throws FileNotFoundException{
		FileReader fr = new FileReader(fileName);
		System.out.println("readFile() from FileReading called...");
	}
}

public class ComplileExceptionTest2 {
	public static void main(String[] args) throws FileNotFoundException{
		FileReading2 file = new FileReading2();
		
		file.readFile("src/adele.txt");
		System.out.println("adele.text reading done...");
	}
}
