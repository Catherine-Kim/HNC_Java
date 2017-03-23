package io.file2.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryDataReadingTest {
	public static void main(String[] args) throws Exception {
		// file name String
		String inputFileName = "src\\io\\file2\\test\\bts.png";
		String outputFileName = "src\\io\\file2\\test\\jk.png";

		// Stream Open
		DataInputStream dis = new DataInputStream(new FileInputStream(inputFileName));
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(outputFileName));

		try {
			// file reading & writing
			int contents = 0;
			while ((contents = dis.readInt()) != -1) {
				dos.writeInt(contents);
			}
		} catch (EOFException e) {
			System.out.println("파일 다 끝남");
		} finally {
			// Stream Close
			dis.close();
			dos.close();
		}
	}
}
