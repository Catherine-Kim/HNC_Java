package userexception.step2.test;

class Account{
	int  balance;
	
	Account(int balance){
		this.balance = balance;
	}
	
	public void deposit(int money) throws AmountInputException{
		System.out.println(money + "원 입금 시도..");
		if(money < 1000){
			throw new AmountInputException();
		}else{
			balance += money;
		}
		System.out.println("[결과] 입금, 성공적. 잔액 : " + balance);
	}
	
	public void withdraw(int money) throws InvalidAmountException{
		System.out.println(money + "원 출금 시도..");
		if(money > balance){
			throw new InvalidAmountException();
		}else{
			balance -= money;
		}
		System.out.println("[결과] 출금, 성공적. 잔액 : " + balance);
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
			System.out.println("[에러] " + e.getMessage());
		}
		try {
			acc.deposit(800);
		} catch (AmountInputException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		}
		try {
			acc.deposit(3000);
		} catch (AmountInputException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		}
		try {
			acc.withdraw(50000);
		} catch (InvalidAmountException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		}
		try {
			acc.withdraw(3000);
		} catch (InvalidAmountException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		}
	}
}
