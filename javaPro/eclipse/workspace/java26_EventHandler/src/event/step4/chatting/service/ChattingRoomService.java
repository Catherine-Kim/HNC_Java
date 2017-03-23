package event.step4.chatting.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import event.step4.chatting.test.ChattingRoomTest;

public class ChattingRoomService implements ActionListener{
	// field
	public ChattingRoomTest crt;
	
	// constructor
	public ChattingRoomService(ChattingRoomTest crt) {
		this.crt = crt;
	}
	
	// actionPerformed() overriding
	@Override
	public void actionPerformed(ActionEvent e) {
		// TextField�� ���� ���� Send ��ư�� �����ų� ���͸� ĥ �� �Ͼ ��
		if((e.getSource() == crt.b1) || (e.getSource() == crt.tf)){
			crt.ta.append(crt.tf.getText() + "\n");		// setText() ���� �������� ������ append() ���
			crt.tf.setText("");							// TextField ���
			crt.tf.requestFocus();						// TextField�� Cursor ����
		}
	}
}
