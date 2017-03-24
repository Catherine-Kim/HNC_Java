package file.step3.test;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChattingSaveService {
	// GUI fields
	Frame f;
	Panel p;
	TextField tf;
	TextArea ta;
	Button save;
	String nickName;
	
	// Constructor
	public ChattingSaveService(String nickName) {
		f = new Frame("Chatting Service");
		p = new Panel();
		tf = new TextField(50);
		ta = new TextArea();
		save = new Button("Save");
		this.nickName = nickName;
	}
	
	public void launchFrame(){
		// Initializing
		f.setSize(500, 300);
		p.add(tf);
		p.add(save);
		f.add(ta, "Center");
		f.add(p, "South");
		f.setBackground(Color.getHSBColor(30, 11, 5));
		ta.setBackground(Color.getHSBColor(3, 15, 70));
		f.setVisible(true);
		
		f.setResizable(false);
		ta.setEditable(false);
		tf.requestFocus();
		ta.setText("[" + nickName + "] ¥‘¿Ã ¿‘¿Â«œºÃΩ¿¥œ¥Ÿ.");
		
		// Event Listener
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		tf.addActionListener(new ActionHandler(this));
		save.addActionListener(new FileSaveHandler(this));
	}
	
	public static void main(String[] args) {
		ChattingSaveService cs = new ChattingSaveService("Cathy");
		cs.launchFrame();
	}
}
