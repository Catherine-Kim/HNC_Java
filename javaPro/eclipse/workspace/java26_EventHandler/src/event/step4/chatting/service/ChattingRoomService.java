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
		// TextField에 글을 쓰고 Send 버튼을 누르거나 엔터를 칠 때 일어날 일
		if((e.getSource() == crt.b1) || (e.getSource() == crt.tf)){
			crt.ta.append(crt.tf.getText() + "\n");		// setText() 쓰면 덮어지기 때문에 append() 사용
			crt.tf.setText("");							// TextField 비움
			crt.tf.requestFocus();						// TextField에 Cursor 세팅
		}
	}
}
