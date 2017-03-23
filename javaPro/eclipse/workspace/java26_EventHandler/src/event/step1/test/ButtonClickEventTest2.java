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
		// Command ����
		//b.setActionCommand("�ִ���?;;");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// ��ư ������ ��, ���� ������ Command�� �ٽ� �޾Ƽ� ����ϰ� �;�
		System.out.println(e.getActionCommand());
	}

	public static void main(String[] args) {
		ButtonClickEventTest2 btest = new ButtonClickEventTest2();
		btest.launchFrame();
	}
}
