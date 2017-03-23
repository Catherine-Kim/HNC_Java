package event.step5.mouse.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import event.step5.mouse.service.MouseMotionHandler;
import event.step5.mouse.service.MouseTestHandler;

public class MouseTest {
	public Frame f;
	public TextField tf;
	public Label l;
	public Font font;		// font
	
	public MouseTest(){
		f = new Frame("Two Listener");
		tf = new TextField(30);
		l = new Label("Click and Drag the mouse", Label.CENTER);
		font = new Font("Serif", Font.BOLD, 17);	// font setting
		l.setFont(font);							// font applying
		l.setForeground(Color.red);					// font color
	}
	
	public void launchFrame(){
		// initializing
		f.setSize(500, 400);
		f.add(tf, "South");
		f.add(l, "North");
		f.setBackground(Color.orange);
		f.setVisible(true);
		tf.setEditable(false);
		
		// WindowListener
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// MouseListener
		f.addMouseListener(new MouseTestHandler(this));
		f.addMouseMotionListener(new MouseMotionHandler(this));
	}

	public static void main(String[] args) {
		MouseTest mt = new MouseTest();
		mt.launchFrame();
	}
}
