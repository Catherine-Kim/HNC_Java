package thread.step2.test;

import java.awt.Toolkit;

public class BeepPrintTest1 {
	public static void main(String[] args) throws InterruptedException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i < 5; i++){
			toolkit.beep();
		}	
	}
}
