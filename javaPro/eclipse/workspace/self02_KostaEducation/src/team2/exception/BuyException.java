package team2.exception;

public class BuyException extends Exception{
	public BuyException(){
		this("BuyException() �߻�...");
	}
	
	public BuyException(String message){
		super(message);
	}
}
