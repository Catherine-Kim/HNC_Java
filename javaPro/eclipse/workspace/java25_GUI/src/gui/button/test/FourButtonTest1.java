package gui.button.test;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class FourButtonTest1 {
	// declaration
	private Frame f;
	private Panel p1;
	private Panel p2;
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;
	private TextField t;
	
	// constructor
	public FourButtonTest1(){
		f = new Frame("Four Buttons");
		p1 = new Panel();
		p2 = new Panel();
		b1 = new Button("김우정");
		b2 = new Button("이알찬");
		b3 = new Button("이예진");
		b4 = new Button("박세연");
		t = new TextField(30);
	}
	
	// launchFrame() : initializing all the components
	public void launchFrame(){
		f.setLayout(new FlowLayout());
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p2.add(t);
		f.setSize(400, 200);
		f.add(p1);
		f.add(p2);
		f.setBackground(Color.getHSBColor(35, 77, 2));
		f.setVisible(true);
	}
	
	// main()
	public static void main(String[] args) {
		FourButtonTest1 fbt = new FourButtonTest1();
		fbt.launchFrame();
	}
}
