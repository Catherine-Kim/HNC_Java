package file.step2.test;

import java.io.File;

class FileSelfExam {
	public void createDirAndFile(String path) throws Exception {
		File file = new File(path);
		boolean b1 = file.getParentFile().mkdirs();
		System.out.println("1. Create directories : " + b1);
		boolean b2 = file.createNewFile();
		System.out.println("2. Created a file : " + b2);
		System.out.println("3. FileName : " + file.getName());
	}
}

public class CreateDirAndFileTest {

	public static void main(String[] args) throws Exception{
		FileSelfExam exam = new FileSelfExam();
		exam.createDirAndFile("c:\\fileexam\\exam1\\test1.mp3");
		exam.createDirAndFile("c:\\fileexam\\exam1\\note.txt");
		exam.createDirAndFile("c:\\fileexam\\exam1\\Hello.java");
		exam.createDirAndFile("c:\\fileexam\\exam1\\greeting.avi");
	}
}
