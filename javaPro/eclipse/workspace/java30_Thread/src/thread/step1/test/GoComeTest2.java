package thread.step1.test;

class GoThread2 implements Runnable{
	@Override
	public void run() {
		int i = 0;
		while(true){
			System.out.println("Go2 :: " + i++);
			if(i == 10) break;
		}
	}
}

class ComeThread2 implements Runnable{
	@Override
	public void run() {
		int i = 0;
		while(true){
			System.out.println("Come2 :: " + i++);
			if(i == 10) break;
		}
	}
}

public class GoComeTest2 {
	public static void main(String[] args) {
		GoThread2 go2 = new GoThread2();
		ComeThread2 come2 = new ComeThread2();
		
		Thread t1 = new Thread(go2);
		Thread t2 = new Thread(come2);
		
		t1.start();
		t2.start();
	}
}
