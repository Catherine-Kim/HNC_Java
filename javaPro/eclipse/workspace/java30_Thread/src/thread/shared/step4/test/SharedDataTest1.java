package thread.shared.step4.test;

class Calculator{
	// field
	private int memory;
	
	// getter and setter
	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory(int memory) {
		this.memory = memory;
		
		// block operating for 2 sec
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + "'s memory value :: " + this.memory);
	}
}

class User1 extends Thread{
	// field
	Calculator calculator;

	// getter and setter
	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		setName("Cal1");
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(100);
	}
}

class User2 extends Thread{
	// field
	Calculator calculator;

	// getter and setter
	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		setName("Cal2");
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(50);
	}
}

public class SharedDataTest1 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(cal);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(cal);
		user2.start();
	}
}
