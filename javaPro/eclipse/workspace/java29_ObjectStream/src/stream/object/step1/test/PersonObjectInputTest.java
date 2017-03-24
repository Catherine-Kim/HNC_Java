package stream.object.step1.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import stream.object.step1.Person;

public class PersonObjectInputTest {

	public static void main(String[] args) throws Exception{
		// variables
		String inputFileName = "c:\\objFile\\person.obj";
		
		// input stream
		FileInputStream fis = new FileInputStream(inputFileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// object reading
		Person p = (Person)ois.readObject();
		System.out.println(p);
		
		// stream closing
		ois.close();
	}
}
