package thread.step3.test;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

class CountingT implements Runnable{
	@Override
	public void run(){
		for (int i = 10; i > 0; i--) {
			// ���� ����� ��Ȯ�� �ԷµǾ��ٸ� for�� ��������
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
			System.out.println("10�� ����. ��ȭâ �����Կ�.");
			System.exit(0);
		}
	}
}

class InputT implements Runnable {
	@Override
	public void run() {
		String input = JOptionPane.showInputDialog("��� �Է��ϻ�");
		System.out.println("�Է��� ���ڴ� " + input + "�Դϴ�.");
		
		// flag ����
		InputThreadTest3.gotPassword = true;
	}
}

public class InputThreadTest3 {
	// Thread ���� ���� �����ϴ� �����͸� �ʵ�� ����
	static boolean gotPassword = false;

	public static void main(String[] args) {
		Thread ct = new Thread(new CountingT());
		Thread it = new Thread(new InputT());

		it.start();
		ct.start();
	}
}
