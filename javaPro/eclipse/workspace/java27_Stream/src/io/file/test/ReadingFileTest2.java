package io.file.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFileTest2{
	public static void main(String[] args) throws IOException{
		String fileName = "src\\io\\file\\test\\hello.txt";
		
		// Input Stream
		// FileInputStream 
		FileInputStream fis = new FileInputStream(fileName);
		System.out.println("Created FileInputStream");
		
		// Output Stream
		System.out.println("\nFileOutputStream ::");
		int data = 0;
		while((data = fis.read()) != -1){
			System.out.println((char)data);
		}
		
		// FileReader
		FileReader fr = new FileReader(fileName);
		while((data = fr.read()) != -1){
			System.out.println((char)data);
		}
	}
}
