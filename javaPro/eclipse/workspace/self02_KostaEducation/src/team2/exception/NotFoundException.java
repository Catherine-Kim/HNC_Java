package team2.exception;

public class NotFoundException extends Exception{
	public NotFoundException(){
		this("NotFoundException() �߻�..");
	}
	public NotFoundException(String message){
		super(message);
	}
}
