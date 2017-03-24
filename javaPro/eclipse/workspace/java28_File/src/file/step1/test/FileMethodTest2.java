package file.step1.test;

import java.io.File;

public class FileMethodTest2 {
	public static void main(String[] args) {
		// File
		File f = new File("src\\file\\step1\\test\\FileMethodTest1.java");
		
		// 1. file name & path
		System.out.println("f.getName() : " + f.getName());
		
		// 2. file name without extension using subString()
		int indexOfDot = f.getName().indexOf(".");
		System.out.println("\nFile name without extension : " + f.getName().substring(0, indexOfDot) );
		
		// 3. extension only
		System.out.println("\nFile extension only : " + f.getName().substring(indexOfDot + 1));
		
		// 4. file path
		System.out.println("\nf.getPath() : " + f.getPath());
		System.out.println("\nf.getAbsolutePath() : " + f.getAbsolutePath());
		
		// 5. getParent() - parent directory path : String
		System.out.println("\nf.getParent() : " + f.getParent());
		
		// 6. getParentFile() - parent directory path : File
		System.out.println("\nf.getParentFile() : " + f.getParentFile());
		
		// 7. File.separator - separator of the OS (static method of File class)
		System.out.println("\nf.File.separator : " + File.separator);
	}
}
