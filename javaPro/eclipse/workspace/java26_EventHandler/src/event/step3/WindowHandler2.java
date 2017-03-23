package event.step3;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowHandler2 extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
