package step3.mvc.exception;

public class DuplicateIdException extends Exception {
	public DuplicateIdException(String message){
		super(message);
	}
	public DuplicateIdException(){
		this("�̹� ��ϵ� ȸ���Դϴ�..");
	}
}
