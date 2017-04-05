package team2.exception;

public class DuplicateIdException extends Exception {
	public DuplicateIdException(String message){
		super(message);
	}
	public DuplicateIdException(){
		this("이미 등록된 회원입니다..");
	}
}
