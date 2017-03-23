package gui.layout.test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

/*
 * Frame���� �⺻���� �����ϴ� BorderLayout�� ���캸���� �ϰڴ�.
 * ��ư�� ���� 5�� ���� Frame���� ����
 * �̶� ������ ��ư�� ��,��, ��, ��, �߾ӿ� ������ �ǵ��� BorderLayout �� ����
 * ���࿡ ������ġ�� �������� ������ �⺻�� Center�� ��� Component�� �������� �ȴ�
 */
public class BorderLayoutTest {
	// ����
	Frame f;
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	
	BorderLayoutTest(){
		// ����
		f=  new Frame("BorderLayout Example...");
		b1 = new Button("B1");
		b2 = new Button("B2");
		b3 = new Button("B3");
		b4 = new Button("B4");
		b5 = new Button("B5");
	}	
	public void lunchFrame(){
		//api�� �����ؼ� 5���� ��ư�� �����ӿ� ��������,�߾ӿ� ������..
		//�������� ������� 200,200
		f.add(b1,"North"); //BorderLayout.NORTH
		f.add(b2,"South"); //BorderLayout.SOUTH
		f.add(b3,"West"); //BorderLayout.WEST
		f.add(b4,"East"); //BorderLayout.EAST
		f.add(b5,"Center"); //BorderLayout.CENTER
		f.setSize(200, 200);
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		BorderLayoutTest test = new BorderLayoutTest();
		test.lunchFrame();
	}
}












