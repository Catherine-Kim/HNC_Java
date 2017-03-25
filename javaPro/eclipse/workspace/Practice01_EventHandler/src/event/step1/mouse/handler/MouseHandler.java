package event.step1.mouse.handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import event.step1.mouse.test.MouseTwoListenerTest;

public class MouseHandler extends MouseAdapter {
	
	MouseTwoListenerTest mtlt = new MouseTwoListenerTest();
	
	public MouseHandler(MouseTwoListenerTest mtlt) {
		this.mtlt = mtlt;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mtlt.tf.setText("Dragged Mouse Location (X, Y) :: (" + e.getX() + ", " + e.getY() + ")");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mtlt.tf.setText("Mouse In");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mtlt.tf.setText("Mouse Out");
	}

}
