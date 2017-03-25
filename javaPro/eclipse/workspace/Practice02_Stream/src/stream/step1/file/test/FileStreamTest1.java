package stream.step1.file.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileStreamTest1 {
	public static void main(String[] args) throws IOException{
		// file name String - input
		String txtFileName = "src\\stream\\step1\\source\\input\\not_today.txt";
		String img1FileName = "src\\stream\\step1\\source\\input\\bts1.jpg";
		String img2FileName = "src\\stream\\step1\\source\\input\\bts2.jpg";
		
		// file name String - output
		String result_txt = "src\\stream\\step1\\source\\output\\result_not_today.txt";
		String result_img1 = "src\\stream\\step1\\source\\output\\result_bts1_img.jpg";
		String result_img2 = "src\\stream\\step1\\source\\output\\result_bts2_img.jpg";
		
		// node stream - input
		FileReader fr = new FileReader(txtFileName);
		FileInputStream fis1 = new FileInputStream(img1FileName);
		FileInputStream fis2 = new FileInputStream(img2FileName);
		
		// filter stream - input
		BufferedReader br = new BufferedReader(fr);
		DataInputStream dis1 = new DataInputStream(fis1);
		DataInputStream dis2 = new DataInputStream(fis2);
		
		// node stream - output
		FileOutputStream fos1 = new FileOutputStream(result_img1);
		FileOutputStream fos2 = new FileOutputStream(result_img2);
		PrintWriter pw = new PrintWriter(result_txt);
		
		// filter strea - output
		DataOutputStream dos1 = new DataOutputStream(fos1);
		DataOutputStream dos2 = new DataOutputStream(fos2);
		
		// Data reading
		String contents = null;
		while((contents = br.readLine()) != null){
			pw.write(contents + "\n");
		}		
		
		pw.close();
		
		int data = 0;
		try {
			while((data = dis1.readInt()) != -1){
				dos1.writeInt(data);
			}
		} catch (EOFException e) {
			System.out.println("프린트 끝");
		}finally{
			dos1.close();
		}
		
		try {
			data = 0;
			while((data = dis2.readInt()) != -1){
				dos2.writeInt(data);
			}
		} catch (Exception e) {
			System.out.println("프린트 끝");
		}finally{
			dos2.close();
		}
			
	}
}
