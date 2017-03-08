package condition.bank.test;

/* 
 * Account Ŭ������ deposit(), withdraw(), getBalance() �� ���� ����� �ִ�.
 * �� �κп��� ����� �����ؼ� Ȱ���غ��� 
 * 1. �ܾ׺��� ū �ݾ��� ��ݺҰ�
 * 2. 1,000�� �̻��� �ݾ׸� �Ա�, ��� ����
 */

class Account{
	int balance;

	public Account(int balance) {		// ���� �־�߸� ���� ������ ����
		this.balance = balance;
	}
	
	public Account() {					// ���� ���� �ʾƵ� ���� ������ ����
		
	}
	
	public void deposit(int amount){	// �Ա��� 1,000�� �̻� ����
		System.out.println("Try " + amount +" Won deposit ::");
		if(amount >= 1000){
			this.balance += amount;
			System.out.println(amount + " Won deposit has been done.\n");
		}
		else
			System.out.println("The amount of money must be equal to and more than 1,000 Won.\n");
	}
	
	public void withdraw(int amount){	// ����� �ܾ� ������ �ݾ׸� ����
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
	 * 1. Account ��ü �ϳ� ����
	 * 2. 3,000�� �Ա�
	 * 3. 5,000�� �Ա�
	 * 4. �ܾ��� Ȯ�� & ���
	 * 5. 9,000�� ���
	 * 6. 2,000�� ���
	 * 7. �ٽ� �ܾ� Ȯ�� & ���  -> 6,000���̾�� ��
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
