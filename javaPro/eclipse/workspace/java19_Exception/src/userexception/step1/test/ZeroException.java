package userexception.step1.test;

public class ZeroException extends Exception{
	public ZeroException(){
		this("This is UserException...");
	}
	
	public ZeroException(String s){
		super(s);
	}
	
}
