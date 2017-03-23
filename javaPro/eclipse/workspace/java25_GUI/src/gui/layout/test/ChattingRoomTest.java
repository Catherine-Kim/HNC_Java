package gui.layout.test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;


public class ChattingRoomTest {
	private Frame f;
	private Panel p1;
	private Panel p2;
	private Panel p3;
	private Button b1;
	private Button b2;
	private TextField tf;
	private TextArea ta;
	
	public ChattingRoomTest(){
		f = new Frame("Chatting Room");
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		b1 = new Button("Send");
		b2 = new Button("Quit");
		tf = new TextField(50);
		ta = new TextArea(10, 50);
	}
	
	public void launchFrame(){
		f.setSize(440,  210);
		//p3.setLayout(new BorderLayout());
		p1.add(b1);
		p2.add(b2);
		p3.setLayout(new GridLayout(5,1));
		p3.add(p1);
		p3.add(p2);
		f.add(p3, "East");
		f.add(tf, "South");
		f.add(ta, "Center");
		f.setBackground(Color.getHSBColor(14, 50, 9));
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		ChattingRoomTest ct = new ChattingRoomTest();
		ct.launchFrame();
	}
}
