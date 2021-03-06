package book.solve;

import book.solve.Account;
import book.solve.User;

class Account {
	private int balance = 1000;

	public int getBalance() {
		return balance;
	}

	public synchronized void withdraw(int money) {
		if (balance >= money) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			balance -= money;
		}
	}
}

class User implements Runnable{
	Account acc = new Account();
	
	@Override
	public void run() {
		while(acc.getBalance() > 0){
			int money = ((int)Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("Balance :: " + acc.getBalance());
		}
	}
}

public class ThreadEx22_770 {
	public static void main(String[] args) {
		Runnable r = new User();
		new Thread(r).start();
		new Thread(r).start();
	}
}
