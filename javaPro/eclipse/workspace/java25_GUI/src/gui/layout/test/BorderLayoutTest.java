package gui.layout.test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

/*
 * Frame에서 기본으로 동작하는 BorderLayout을 살펴보도록 하겠다.
 * 버튼을 각각 5개 만들어서 Frame에다 부착
 * 이때 각각의 버튼이 동,서, 남, 북, 중앙에 부착이 되도록 BorderLayout 을 지정
 * 만약에 부착위치를 지정하지 않으면 기본은 Center로 가운에 Component만 보여지게 된다
 */
public class BorderLayoutTest {
	// 선언
	Frame f;
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	
	BorderLayoutTest(){
		// 생성
		f=  new Frame("BorderLayout Example...");
		b1 = new Button("B1");
		b2 = new Button("B2");
		b3 = new Button("B3");
		b4 = new Button("B4");
		b5 = new Button("B5");
	}	
	public void lunchFrame(){
		//api를 참조해서 5개의 버튼을 프레임에 동서남북,중앙에 부착함..
		//프레임의 사이즈는 200,200
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












