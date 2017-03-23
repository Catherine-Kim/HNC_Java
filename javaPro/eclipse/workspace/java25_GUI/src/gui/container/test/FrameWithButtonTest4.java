package gui.container.test;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class FrameWithButtonTest4 {
	// declaration
	private Frame f;
	private Panel p;
	private Button b1;
	private Button b2;
	private Button b3;

	// constructor
	public FrameWithButtonTest4() {
		f = new Frame("FrameWithPanel");
		p = new Panel();
		b1 = new Button("Add");
		b2 = new Button("Delete");
		b3 = new Button("Update");
	}
	
	public void launchFrame(){
		f.setSize(500, 300);
		f.setBackground(Color.MAGENTA);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		f.add(p, "Center");
		f.setVisible(true);
	}

	public static void main(String[] args) {
		FrameWithButtonTest4 fwbt = new FrameWithButtonTest4();
		fwbt.launchFrame();
	}
}
