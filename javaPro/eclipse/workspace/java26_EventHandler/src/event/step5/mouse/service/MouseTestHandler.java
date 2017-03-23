package event.step5.mouse.service;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import event.step5.mouse.test.MouseTest;

public class MouseTestHandler extends MouseAdapter{
	// field
	public MouseTest mt;
	
	// constructor
	public MouseTestHandler(MouseTest mt){
		this.mt = mt;
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		mt.tf.setForeground(Color.magenta);
		mt.tf.setText("마우스가 프레임 영역 밖으로 나갔습니다.");
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		mt.tf.setForeground(Color.magenta);
		mt.tf.setText("마우스가 프레임 영역 안으로 들어왔습니다.");
	}
}
