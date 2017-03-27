package thread.step3.test;

import javax.swing.JOptionPane;

public class InputThreadTest2 {
	public static void main(String[] args) throws InterruptedException {
		String input = JOptionPane.showInputDialog("Input any number");
		
		System.out.println("입력하신 숫자는 " + input + "입니다.");
		
		for(int i = 10; i > 0; i--){
			System.out.println(i);
			Thread.sleep(1000);
		}
	}
}
