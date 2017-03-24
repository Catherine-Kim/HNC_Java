package file.step1.test;

import java.io.File;

public class FileMethodTest1 {
	public static void main(String[] args) {
		// File
		File dir1 = new File("c:\\filetest\\step1\\code");
		File dir2 = new File("c:\\filetest1");
		
		// 1. Creating directories
		dir1.mkdirs();
		dir2.mkdir();
		
		System.out.println("Check out if the directoreis have been made");
		
		// 2. parent directories : getParent() | getParentFile()
		String fileParent = dir1.getParent();
		System.out.println("\ndir1.getParent() : " + fileParent);
		
		File parentOfDir1 = dir1.getParentFile();
		System.out.println("\nParent of fileParent : " + parentOfDir1.getParentFile());
		System.out.println("\nParent of Parent of fileParent : " 
								+ parentOfDir1.getParentFile().getParentFile());
		
		// 3. listFiles() | isFile() | isDirectory()
		File[] files = parentOfDir1.listFiles();
		System.out.println(files.length);
		for(int i = 0; i < files.length; i++){
			if(files[i].isFile())				// when it's a file
				System.out.println("listFiles[" + i + "] : " + files[i].getName());
			else								// when it's a directory
				System.out.println("listFiles[" + i + "] : " + files[i].getPath());
		}
	}
}
