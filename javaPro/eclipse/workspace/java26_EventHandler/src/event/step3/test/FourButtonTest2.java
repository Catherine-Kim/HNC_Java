package event.step3.test;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import event.step3.WindowHandler2;

public class FourButtonTest2{
	// declaration
	public Frame f;
	public Panel p1;
	public Panel p2;
	public Button b1;
	public Button b2;
	public Button b3;
	public Button b4;
	public TextField t;
	
	// constructor
	public FourButtonTest2(){
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
	
		b1.addActionListener(new FourButtonTest2Handler(this));
		b2.addActionListener(new FourButtonTest2Handler(this));
		b3.addActionListener(new FourButtonTest2Handler(this));
		b4.addActionListener(new FourButtonTest2Handler(this));
		
		// Frame 종료 기능 추가
		// f.addWindowListener(new WindowHandler());
		// f.addWindowListener(new WindowHandler2());
		// f.addWindowListener(new FourButtonTest2Handler(this));
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	// main()
	public static void main(String[] args) {
		FourButtonTest2 fbt = new FourButtonTest2();
		fbt.launchFrame();
	}
}
