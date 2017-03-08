package condition.bank.test;

/* 
 * Account 클래스는 deposit(), withdraw(), getBalance() 세 가지 기능이 있다.
 * 이 부분에서 제어문을 연결해서 활용해보자 
 * 1. 잔액보다 큰 금액은 출금불가
 * 2. 1,000원 이상의 금액만 입금, 출금 가능
 */

class Account{
	int balance;

	public Account(int balance) {		// 돈을 넣어야만 계좌 개설이 가능
		this.balance = balance;
	}
	
	public Account() {					// 돈을 넣지 않아도 계좌 개설이 가능
		
	}
	
	public void deposit(int amount){	// 입금은 1,000원 이상만 가능
		System.out.println("Try " + amount +" Won deposit ::");
		if(amount >= 1000){
			this.balance += amount;
			System.out.println(amount + " Won deposit has been done.\n");
		}
		else
			System.out.println("The amount of money must be equal to and more than 1,000 Won.\n");
	}
	
	public void withdraw(int amount){	// 출금은 잔액 이하의 금액만 가능
		System.out.println("Try " + amount +" Won withdraw ::");
		if(amount <= balance){
			this.balance -= amount;
			System.out.println(amount + " Won withdraw has been done.\n");
		}
		else{
			System.out.println("The amount of money is bigger than your balance.\n");
			return;
		}
	}
	
	public int getBalance(){
		return balance;
	}
}

public class BankingIfTest {
	/*
	 * 1. Account 객체 하나 생성
	 * 2. 3,000원 입금
	 * 3. 5,000원 입금
	 * 4. 잔액을 확인 & 출력
	 * 5. 9,000원 출력
	 * 6. 2,000원 출력
	 * 7. 다시 잔액 확인 & 출력  -> 6,000원이어야 함
	 */
	public static void main(String[] args) {
		Account woojeongK = new Account();
		System.out.println("You just made an account.\n");
		
		woojeongK.deposit(3000);
		
		woojeongK.deposit(5000);
		System.out.println("Now your balance is " + woojeongK.getBalance() + " Won.\n");
		
		woojeongK.withdraw(9000);
		
		woojeongK.withdraw(2000);
		System.out.println("Now your balance is " + woojeongK.getBalance() + " Won.\n");
	}
}
