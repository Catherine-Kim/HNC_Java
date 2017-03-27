package thread.step2.test;

import java.awt.Toolkit;

class BeepThread extends Thread{
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i < 5; i++){
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class BeepPrintTest2 {
	public static void main(String[] args) throws InterruptedException {
		BeepThread beep = new BeepThread();
		beep.start();
		for(int i = 0; i < 5; i++){
			System.out.println("Beep");
		}	
	}
}
