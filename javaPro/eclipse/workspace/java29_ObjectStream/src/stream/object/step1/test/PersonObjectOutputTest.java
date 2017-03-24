package stream.object.step1.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import stream.object.step1.Person;

public class PersonObjectOutputTest {

	public static void main(String[] args) throws Exception{
		// variables
		Person p = new Person("Woojeong Kim", 24, "abcdcba", "Republic of Korea");
		String outputFileName = "c:\\objFile\\person.obj";
		
		File file = new File(outputFileName);
		file.getParentFile().mkdirs();
		file.createNewFile();
		
		// OutputStream
		FileOutputStream fos = new FileOutputStream(outputFileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// Object writing
		oos.writeObject(p);
		
		// Stream closing
		oos.close();
	}
}
