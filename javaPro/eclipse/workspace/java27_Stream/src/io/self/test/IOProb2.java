package io.self.test;

import java.io.*;

public class IOProb2 {
	public static void main(String[] args) throws Exception {
		String fileName = "src\\io\\self\\test\\data.txt";
		System.out.println("<< world 가 들어있는 라인 >>");
		searchWord(fileName, "world");
		System.out.println("<< you 가 들어있는 라인 >>");
		searchWord(fileName, "you");
	}

	private static void searchWord(String fileName, String searchKeyword) throws Exception {
		// LineNumberReader
		LineNumberReader lr = new LineNumberReader(new BufferedReader(new FileReader(fileName)));

		// file reading and writing
		String contents = null;
		while ((contents = lr.readLine()) != null) {
			String[] contents_split = contents.split(" ");
			
			for (String str : contents_split){
				if(str.contains(searchKeyword)){
					System.out.println(lr.getLineNumber() + "-Line");
				}
			}
		}
		lr.close();
	}
}
