package team2.exception;

public class NotFoundException extends Exception{
	public NotFoundException(){
		this("NotFoundException() ¹ß»ý..");
	}
	public NotFoundException(String message){
		super(message);
	}
}
