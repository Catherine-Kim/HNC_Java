package event.step2.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {
	// actionPerformed() overriding
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Pressed Button..");
	}
}
