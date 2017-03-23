/*
 * Frame, Panel, Button3 �� ����
 * Button�� Ÿ��Ʋ�� "Open", "Close", "Visit"
 * Frame�� ������� ������ ���� �ʴ´�...pack()
 * ::
 * 1. ���������ʹ� �޸� Button���� Panel(FlowLayout)�� �����ϹǷ�
 * setLayout()�� ������� �ʾƵ� �ȴ�.
 * 
 * 2. FlowLayout�� ����Ʈ ��ġ�� ��Ÿ��
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
		f.setSize(100, 100);//pack()�� ������ �ٽ� �ѹ� ����!!
		f.setVisible(true);
	}
	public static void main(String[] args) {
		FlowLayoutTest test = new FlowLayoutTest();
		test.lunchFrame();
	}

}











