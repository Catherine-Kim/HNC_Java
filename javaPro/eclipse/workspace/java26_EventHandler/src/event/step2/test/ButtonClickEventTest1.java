package event.step2.test;

import java.awt.Button;
import java.awt.Frame;

public class ButtonClickEventTest1 {
	// declaration
	private Frame f;
	private Button b;
	
	// constructor
	public ButtonClickEventTest1(){
		f = new Frame("Event Handler");
		b = new Button("Click");
	}
	
	// Initializing
	public void launchFrame(){
		f.add(b);
		f.pack();
		f.setVisible(true);
		
		// ButtonHandler 클래스를 따로 만들어서 기능 구현 부분 다룸
		b.addActionListener(new ButtonHandler());
	}

	public static void main(String[] args) {
		ButtonClickEventTest1 btest = new ButtonClickEventTest1();
		btest.launchFrame();
	}
}
