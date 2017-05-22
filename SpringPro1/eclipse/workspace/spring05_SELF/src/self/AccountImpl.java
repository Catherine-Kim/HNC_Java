package self;

public class AccountImpl implements Account{
	// field
	private double balance;
	private int number;
	
	// constructor
	public AccountImpl(double balance, int number) {
		this.balance = balance;
		this.number = number;
	}
	
	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "AccountImpl [balance=" + balance + ", number=" + number + "]";
	}
}
