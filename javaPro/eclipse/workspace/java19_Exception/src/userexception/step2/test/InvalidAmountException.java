package userexception.step2.test;

public class InvalidAmountException extends Exception{
	public InvalidAmountException(){
		this("잔액을 확인하고 다시 출금하셈");
	}
	
	public InvalidAmountException(String message){
		super(message);
	}
}
