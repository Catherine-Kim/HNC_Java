package gui.container.test;

import java.awt.Color;
import java.awt.Frame;

public class FrameContainerTest1 {
	private Frame f;
	
	public FrameContainerTest1(){
		f = new Frame("Frame Test");
		f.setSize(500, 400);
		f.setBackground(Color.YELLOW);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new FrameContainerTest1();	// 앞에 객체 변수를 선언할 필요 없음
	}
}
