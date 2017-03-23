package event.step1.test;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickEventTest1 implements ActionListener{
	// 1. GUI 구성
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
		
		// 2. Listener 부착
		b.addActionListener(this);	// this : 이 클래스
	}
	
	// 3. 이벤트 처리 루틴 구현 : ActionLister 인터페이스의 메소드 구현
	// 이 부분만 개발자가 하면 됨
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Pressed Button..");
	}

	public static void main(String[] args) {
		ButtonClickEventTest1 btest = new ButtonClickEventTest1();
		btest.launchFrame();
	}
}
