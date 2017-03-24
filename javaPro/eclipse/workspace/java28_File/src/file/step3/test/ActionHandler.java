package file.step3.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
	ChattingSaveService cs;

	public ActionHandler(ChattingSaveService cs) {
		this.cs = cs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (cs.tf.getText().equals(""))
			return;
		cs.ta.append("\n" + cs.tf.getText());
		cs.tf.setText("");
		cs.tf.requestFocus();
	}
}
