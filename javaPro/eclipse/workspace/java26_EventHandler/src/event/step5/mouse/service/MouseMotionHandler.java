package event.step5.mouse.service;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import event.step5.mouse.test.MouseTest;

public class MouseMotionHandler extends MouseMotionAdapter {
	// field
	public MouseTest mt;
	
	// constructor
	public MouseMotionHandler(MouseTest mt){
		this.mt = mt;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mt.tf.setForeground(Color.BLUE);
		mt.tf.setText("Mouse Dragged (X, Y) :: (" + e.getX() + ", " + e.getY() + ")");
	}
}
