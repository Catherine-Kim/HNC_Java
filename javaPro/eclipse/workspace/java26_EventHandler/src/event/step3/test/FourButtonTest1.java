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
		b1 = new Button("�޸���");
		b2 = new Button("��ũ��");
		b3 = new Button("����Ÿ");
		b4 = new Button("����");
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
		if(e.getActionCommand().equals("�޸���"))
			t.setText("�� ������ ���� �ʾƿ�");
		else if(e.getActionCommand().equals("��ũ��"))
			t.setText("����ġ�� �� ���� ������");
		else if(e.getActionCommand().equals("����Ÿ"))
			t.setText("��並 ü���Ͻÿ�");
		else
			t.setText("���� �Ͱ� ŸŰ�� ���");	
	}*/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)
			t.setText("�� ������ ���� �ʾƿ�");
		else if(e.getSource() == b2)
			t.setText("����ġ�� �� ���� ������");
		else if(e.getSource() == b3)
			t.setText("��並 ü���Ͻÿ�");
		else
			t.setText("���� �Ͱ� ŸŰ�� ���");	
	}
	
	// main()
	public static void main(String[] args) {
		FourButtonTest1 fbt = new FourButtonTest1();
		fbt.launchFrame();
	}
}
