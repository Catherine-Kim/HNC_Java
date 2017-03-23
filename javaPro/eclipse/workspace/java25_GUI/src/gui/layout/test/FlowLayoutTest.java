/*
 * Frame, Panel, Button3 개 생성
 * Button의 타이틀은 "Open", "Close", "Visit"
 * Frame의 사이즈는 별도로 주지 않는다...pack()
 * ::
 * 1. 이전예제와는 달리 Button들을 Panel(FlowLayout)에 부착하므로
 * setLayout()을 사용하지 않아도 된다.
 * 
 * 2. FlowLayout의 디폴트 위치는 센타다
 */
package gui.layout.test;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class FlowLayoutTest {
	Frame f;
	Panel p;
	Button b1; Button b2; Button b3;
	
	FlowLayoutTest(){
		f = new Frame("FlowLayout...");
		p= new Panel();
		b1 = new Button("Open");
		b2 = new Button("Close");
		b3 = new Button("Visit");
	}
	
	public void lunchFrame(){
		p.add(b1); p.add(b2); p.add(b3);
		f.add(p);
		f.setSize(100, 100);//pack()의 잇점을 다시 한번 생각!!
		f.setVisible(true);
	}
	public static void main(String[] args) {
		FlowLayoutTest test = new FlowLayoutTest();
		test.lunchFrame();
	}

}











