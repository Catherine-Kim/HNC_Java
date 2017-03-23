package event.step3.test;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FourButtonTest2Handler extends WindowAdapter implements ActionListener{
	// declaration
	public FourButtonTest2 f;
	
	public FourButtonTest2Handler(FourButtonTest2 f){
		this.f = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == f.b1)
			f.t.setText("�� ������ ���� �ʾƿ�");
		else if(e.getSource() == f.b2)
			f.t.setText("����ġ�� �� ���� ������");
		else if(e.getSource() == f.b3)
			f.t.setText("��並 ü���Ͻÿ�");
		else
			f.t.setText("���� �Ͱ� ��Ű�� ���");	
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
