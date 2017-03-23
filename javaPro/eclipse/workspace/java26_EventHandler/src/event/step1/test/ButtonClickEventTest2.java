package event.step1.test;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickEventTest2 implements ActionListener{
	private Frame f;
	private Button b;
	
	public ButtonClickEventTest2(){
		f = new Frame("Event Handler");
		b = new Button("Click");
	}
	
	public void launchFrame(){
		f.add(b);
		f.pack();
		f.setVisible(true);
		b.addActionListener(this);
		// Command 주입
		//b.setActionCommand("왜누름?;;");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 눌렀을 때, 내가 주입한 Command를 다시 받아서 출력하고 싶어
		System.out.println(e.getActionCommand());
	}

	public static void main(String[] args) {
		ButtonClickEventTest2 btest = new ButtonClickEventTest2();
		btest.launchFrame();
	}
}
