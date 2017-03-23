package gui.container.test;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

public class FrameWithButtonTest2 {
	// declaration
	private Frame f;
	private Button b1;
	private Button b2;
	private Button b3;

	// constructor
	public FrameWithButtonTest2() {
		f = new Frame("Hello, it's frame :)");
		b1 = new Button("Add");
		b2 = new Button("Delete");
		b3 = new Button("Update");
	}
	
	public void launchFrame(){
		f.setSize(500, 300);
		f.setBackground(Color.MAGENTA);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		FrameWithButtonTest2 fwbt = new FrameWithButtonTest2();
		fwbt.launchFrame();
	}
}
