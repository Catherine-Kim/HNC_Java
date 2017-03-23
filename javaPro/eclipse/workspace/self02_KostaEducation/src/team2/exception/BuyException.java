package team2.exception;

public class BuyException extends Exception{
	public BuyException(){
		this("BuyException() ¹ß»ý...");
	}
	
	public BuyException(String message){
		super(message);
	}
}
