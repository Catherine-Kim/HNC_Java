package io.self.test;

import java.io.*;
import java.util.*;

class IOProb1{
	public static void main(String[] args) throws Exception{
		// file name String
		String inputFileName = "src\\io\\self\\test\\score.txt";
		
		// Stream
		BufferedReader br = new BufferedReader(new FileReader(inputFileName));
		PrintWriter pw = new PrintWriter(new FileWriter(inputFileName, true));
		
		// file reading and writing
		String line = null;
		int sum = 0;
		int count = 0;
		while((line = br.readLine()) != null){
			sum += Integer.parseInt(line.split(":")[1]);
			count++;
		}
		pw.write("\n√—¡°:" + sum);
		pw.write("\n∆Ú±’:" + (float)(sum/count));
		
		br.close();
		pw.close();
	}
}
