package userexception.step2.test;

public class AmountInputException extends Exception{
	public AmountInputException(){
		this("1,000 이상의 금액부터 입금 가능하심");
	}
	
	public AmountInputException(String message){
		super(message);
	}
}
