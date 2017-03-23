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
			f.t.setText("내 영웅은 죽지 않아요");
		else if(e.getSource() == f.b2)
			f.t.setText("깽판치기 딱 좋은 날씨군");
		else if(e.getSource() == f.b3)
			f.t.setText("고요를 체험하시오");
		else
			f.t.setText("류요 와가 테키오 쿠라에");	
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
