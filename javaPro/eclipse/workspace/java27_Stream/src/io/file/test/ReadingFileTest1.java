package io.file.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFileTest1{
	public static void main(String[] args) throws IOException{
		String fileName = "src\\io\\file\\test\\hello.txt";
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String s = null;
		while((s = br.readLine()) != null){
			System.out.println(s);
		}
		
		br.close();
	}
}
