package thread.step3.test;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

class CountingT implements Runnable{
	@Override
	public void run(){
		for (int i = 10; i > 0; i--) {
			// 만약 비번이 정확히 입력되었다면 for문 빠져나옴
			if(InputThreadTest3.gotPassword) break;
			Toolkit tk = Toolkit.getDefaultToolkit();
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(!InputThreadTest3.gotPassword){
			System.out.println("10초 끝남. 대화창 닫을게염.");
			System.exit(0);
		}
	}
}

class InputT implements Runnable {
	@Override
	public void run() {
		String input = JOptionPane.showInputDialog("비번 입력하삼");
		System.out.println("입력한 숫자는 " + input + "입니다.");
		
		// flag 변경
		InputThreadTest3.gotPassword = true;
	}
}

public class InputThreadTest3 {
	// Thread 들이 서로 공유하는 데이터를 필드로 지정
	static boolean gotPassword = false;

	public static void main(String[] args) {
		Thread ct = new Thread(new CountingT());
		Thread it = new Thread(new InputT());

		it.start();
		ct.start();
	}
}
