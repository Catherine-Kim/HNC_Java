package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter{
	private String filePath;
	
	public FileOutputter(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public void output(String message) throws IOException {
		// message를 filePath로 출력
		File file = new File(filePath);
		file.getParentFile().mkdirs();
		file.createNewFile();
		
		FileWriter fw = new FileWriter(filePath);
		fw.write(message);
		fw.close();
	}
}
