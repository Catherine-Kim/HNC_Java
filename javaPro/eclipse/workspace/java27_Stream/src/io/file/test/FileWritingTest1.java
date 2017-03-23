package io.file.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritingTest1 {
	public static void main(String[] args) throws IOException{
		// file name string
		String inputFileName = "src\\io\\file\\test\\hello.txt";
		String outputFileName = "src\\io\\file\\test\\result.txt";
		
		// Stream
		BufferedReader br = new BufferedReader(new FileReader(inputFileName));
		System.out.println("Created BufferedReader");
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));
		System.out.println("Created BufferedWriter");
		
		String contents = null;
		while((contents = br.readLine()) != null){
			bw.write(contents);
			bw.newLine();
		}
		
		//bw.close();
		bw.flush();
	}
}
