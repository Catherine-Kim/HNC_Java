package thread.step3.test;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

class CountingThread implements Runnable{
	@Override
	public void run() {
		for(int i = 10; i > 0; i--){
			Toolkit tk = Toolkit.getDefaultToolkit();
			tk.beep();
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class InputThreadTest1 {
	public static void main(String[] args){
		String input = JOptionPane.showInputDialog("Input any number");
		Thread ct = new Thread(new CountingThread());
		
		ct.start();
	}
}
