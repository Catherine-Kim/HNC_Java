package userexception.step2.test;

public class AmountInputException extends Exception{
	public AmountInputException(){
		this("1,000 �̻��� �ݾ׺��� �Ա� �����Ͻ�");
	}
	
	public AmountInputException(String message){
		super(message);
	}
}
