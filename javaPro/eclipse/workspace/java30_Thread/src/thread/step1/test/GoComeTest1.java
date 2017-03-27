package thread.step1.test;

class GoThread extends Thread{
	int i= 0;
	
	@Override
	public void run() {
		int i = 0;
		while(true){
			System.out.println("Go :: " + i++);
			if(i == 20) break;
		}
	}
}

class ComeThread extends Thread{
	int i= 0;
	
	@Override
	public void run() {
		int i = 0;
		while(true){
			System.out.println("Come :: " + i++);
			if(i == 20) break;
		}
	}
}

public class GoComeTest1 {
	public static void main(String[] args) {
		GoThread go = new GoThread();
		ComeThread come = new ComeThread();
		
		/*go.run();
		come.run();*/
		go.start();
		come.start();
	}
}
