package gui.container.test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;

public class FrameWithButtonTest5 {
	// declaration
	private Frame f;
	private Button b1;
	private Button b2;
	private Button b3;

	// constructor
	public FrameWithButtonTest5() {
		f = new Frame("SetLayoutManager");
		b1 = new Button("Add");
		b2 = new Button("Delete");
		b3 = new Button("Update");
	}
	
	public void launchFrame(){
		f.setLayout(new FlowLayout());	// FlowLayoutÀ» »ý¼º
		f.setSize(500, 300);
		f.setBackground(Color.MAGENTA);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		FrameWithButtonTest5 fwbt = new FrameWithButtonTest5();
		fwbt.launchFrame();
	}
}
