package event.step3.test;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FourButtonTest1 implements ActionListener{
	// declaration
	private Frame f;
	private Panel p1;
	private Panel p2;
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;
	private TextField t;
	
	// constructor
	public FourButtonTest1(){
		f = new Frame("Four Buttons");
		p1 = new Panel();
		p2 = new Panel();
		b1 = new Button("메르시");
		b2 = new Button("정크랫");
		b3 = new Button("젠야타");
		b4 = new Button("한조");
		t = new TextField(30);
	}
	
	// launchFrame() : initializing all the components
	public void launchFrame(){
		f.setLayout(new FlowLayout());
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p2.add(t);
		f.setSize(400, 200);
		f.add(p1);
		f.add(p2);
		f.setBackground(Color.getHSBColor(35, 77, 2));
		f.setVisible(true);
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
	
	// actionPerformed() Overriding
	/*@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("메르시"))
			t.setText("내 영웅은 죽지 않아요");
		else if(e.getActionCommand().equals("정크랫"))
			t.setText("깽판치기 딱 좋은 날씨군");
		else if(e.getActionCommand().equals("젠야타"))
			t.setText("고요를 체험하시오");
		else
			t.setText("류요 와가 타키오 쿠라에");	
	}*/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)
			t.setText("내 영웅은 죽지 않아요");
		else if(e.getSource() == b2)
			t.setText("깽판치기 딱 좋은 날씨군");
		else if(e.getSource() == b3)
			t.setText("고요를 체험하시오");
		else
			t.setText("류요 와가 타키오 쿠라에");	
	}
	
	// main()
	public static void main(String[] args) {
		FourButtonTest1 fbt = new FourButtonTest1();
		fbt.launchFrame();
	}
}
