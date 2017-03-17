package userexception.step2.test;

class Account{
	int  balance;
	
	Account(int balance){
		this.balance = balance;
	}
	
	public void deposit(int money) throws AmountInputException{
		System.out.println(money + "�� �Ա� �õ�..");
		if(money < 1000){
			throw new AmountInputException();
		}else{
			balance += money;
		}
		System.out.println("[���] �Ա�, ������. �ܾ� : " + balance);
	}
	
	public void withdraw(int money) throws InvalidAmountException{
		System.out.println(money + "�� ��� �õ�..");
		if(money > balance){
			throw new InvalidAmountException();
		}else{
			balance -= money;
		}
		System.out.println("[���] ���, ������. �ܾ� : " + balance);
	}
	
	public int getBalance(){
		return balance;
	}
}

public class BankAccountTest2 {
	public static void main(String[] args) {
		Account acc = new Account(10000);
		
		try {
			acc.deposit(20000);
		} catch (AmountInputException e) {
			// TODO Auto-generated catch block
			System.out.println("[����] " + e.getMessage());
		}
		try {
			acc.deposit(800);
		} catch (AmountInputException e) {
			// TODO Auto-generated catch block
			System.out.println("[����] " + e.getMessage());
		}
		try {
			acc.deposit(3000);
		} catch (AmountInputException e) {
			// TODO Auto-generated catch block
			System.out.println("[����] " + e.getMessage());
		}
		try {
			acc.withdraw(50000);
		} catch (InvalidAmountException e) {
			// TODO Auto-generated catch block
			System.out.println("[����] " + e.getMessage());
		}
		try {
			acc.withdraw(3000);
		} catch (InvalidAmountException e) {
			// TODO Auto-generated catch block
			System.out.println("[����] " + e.getMessage());
		}
	}
}
