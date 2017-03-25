package event.step1.mouse.test;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import event.step1.mouse.handler.MouseHandler;

public class MouseTwoListenerTest {
	// fields
	public Frame f;
	public Label l;
	public TextField tf;
	
	// constructors
	public MouseTwoListenerTest(){
		f = new Frame("Two Listener Test");
		l = new Label("Click and Drag the mouse.");
		tf = new TextField(50);
	}
	
	public void launchFrame(){
		// initializing
		f.setSize(500, 400);
		f.add(l, "North");
		f.add(tf, "South");
		f.setBackground(Color.LIGHT_GRAY);
		f.setVisible(true);
		
		// closing window
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// actionListener
		f.addMouseListener(new MouseHandler(this));
		f.addMouseMotionListener(new MouseHandler(this));
	}
	
	public static void main(String[] args) {
		MouseTwoListenerTest mtlt = new MouseTwoListenerTest();
		mtlt.launchFrame();
	}
}
