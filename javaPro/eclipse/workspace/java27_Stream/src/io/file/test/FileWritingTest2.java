package io.file.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWritingTest2 {
	public static void main(String[] args) throws IOException{
		// file name string
		String inputFileName = "src\\hello.txt";
		String outputFileName = "src\\out.txt";
		
		// BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(inputFileName));
		System.out.println("Created BufferedReader");
		System.out.println("Created BufferedWriter");
		
		// PrintWriter
		PrintWriter pw = new PrintWriter(new FileWriter(outputFileName, true));
		
		// Data reading and writing
		String contents = null;
		while((contents = br.readLine()) != null){
			pw.println(contents);
		}
		
		pw.close();
	}
}
