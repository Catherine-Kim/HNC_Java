package team2.exception;

public class DuplicateModelException extends Exception {
	public DuplicateModelException(String message){
		super(message);
	}
	public DuplicateModelException(){
		this("이미 등록된 회원입니다..");
	}
}
