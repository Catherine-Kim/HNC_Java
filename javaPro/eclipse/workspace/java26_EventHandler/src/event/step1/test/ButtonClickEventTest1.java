package event.step1.test;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickEventTest1 implements ActionListener{
	// 1. GUI ����
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
		
		// 2. Listener ����
		b.addActionListener(this);	// this : �� Ŭ����
	}
	
	// 3. �̺�Ʈ ó�� ��ƾ ���� : ActionLister �������̽��� �޼ҵ� ����
	// �� �κи� �����ڰ� �ϸ� ��
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Pressed Button..");
	}

	public static void main(String[] args) {
		ButtonClickEventTest1 btest = new ButtonClickEventTest1();
		btest.launchFrame();
	}
}
