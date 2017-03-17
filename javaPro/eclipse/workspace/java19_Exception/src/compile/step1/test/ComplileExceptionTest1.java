package compile.step1.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading{
	public void readFile(String fileName) throws FileNotFoundException{
		FileReader fr = new FileReader(fileName);
		System.out.println("readFile() from FileReading called...");
	}
}

public class ComplileExceptionTest1 {
	public static void main(String[] args) {
		FileReading file = new FileReading();
		try {
			file.readFile("src/adele.txt");
			System.out.println("adele.text reading done...");
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Not ready to read a file...");
		}
	}
}
