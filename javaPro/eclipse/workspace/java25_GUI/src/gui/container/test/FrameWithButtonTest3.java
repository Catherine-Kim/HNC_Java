package gui.container.test;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

public class FrameWithButtonTest3 {
	// declaration
	private Frame f;
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;
	private Button b5;

	// constructor
	public FrameWithButtonTest3() {
		f = new Frame("Hello, it's frame :)");
		b1 = new Button("Add");
		b2 = new Button("Delete");
		b3 = new Button("Update");
		b4 = new Button("Find");
		b5 = new Button("Apply");
	}
	
	public void launchFrame(){
		f.setSize(500, 300);
		f.setBackground(Color.MAGENTA);
		f.add(b1, "East");
		f.add(b2, "West");
		f.add(b3, "Center");
		f.add(b4, "North");
		f.add(b5, "South");
		f.setVisible(true);
	}

	public static void main(String[] args) {
		FrameWithButtonTest3 fwbt = new FrameWithButtonTest3();
		fwbt.launchFrame();
	}
}
