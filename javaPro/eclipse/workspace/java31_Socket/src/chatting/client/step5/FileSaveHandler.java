package chatting.client.step5;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileSaveHandler implements ActionListener{
	ChattingSaveService cs;

	public FileSaveHandler(ChattingSaveService cs) {
		this.cs = cs;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		FileDialog fd = new FileDialog(cs.f, "Dialogue", FileDialog.SAVE);
		fd.setVisible(true);

		String fullName = fd.getDirectory() + fd.getFile();
		System.out.println(fullName);
		
		try {
			writeFileCreate(fullName);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void writeFileCreate(String path) throws Exception{
		PrintWriter pw = new PrintWriter(path);
		pw.println(cs.ta.getText());
		pw.close();
	}
}
