package event.step4.chatting.test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import event.step4.chatting.service.ChattingRoomService;


public class ChattingRoomTest {
	public Frame f;
	public Panel p1;
	public Panel p2;
	public Panel p3;
	public Button b1;
	public Button b2;
	public TextField tf;
	public TextArea ta;
	
	public ChattingRoomTest(){
		f = new Frame("Chatting Room");
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		b1 = new Button("Send");
		b2 = new Button("Quit");
		tf = new TextField(50);
		ta = new TextArea(10, 50);
	}
	
	public void launchFrame(){
		f.setSize(440,  210);
		p1.add(b1);
		p2.add(b2);
		p3.setLayout(new GridLayout(5,1));
		p3.add(p1);
		p3.add(p2);
		f.add(p3, "East");
		f.add(tf, "South");
		f.add(ta, "Center");
		f.setBackground(Color.getHSBColor(14, 50, 9));
		f.setVisible(true);
		
		// frame 창 종료
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});;
		
		// 추가하는 부분
		tf.requestFocus();
		ta.setEditable(false);
		ta.setBackground(Color.lightGray);	// textarea가 비활성화된 걸 강조
		
		// ActionListener 추가
		tf.addActionListener(new ChattingRoomService(this));
		b1.addActionListener(new ChattingRoomService(this));
	}
	
	public static void main(String[] args) {
		ChattingRoomTest ct = new ChattingRoomTest();
		ct.launchFrame();
	}
}
