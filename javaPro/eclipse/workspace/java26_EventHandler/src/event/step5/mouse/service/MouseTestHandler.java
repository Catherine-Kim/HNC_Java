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
		mt.tf.setText("���콺�� ������ ���� ������ �������ϴ�.");
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		mt.tf.setForeground(Color.magenta);
		mt.tf.setText("���콺�� ������ ���� ������ ���Խ��ϴ�.");
	}
}
