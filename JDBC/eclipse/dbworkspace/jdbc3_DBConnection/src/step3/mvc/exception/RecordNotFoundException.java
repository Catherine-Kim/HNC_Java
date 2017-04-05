package step3.mvc.exception;

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException(String message){
		super(message);
	}
	public RecordNotFoundException(){
		this("그런 아이디를 가진 회원 없어여..");
	}
}
