package team2.exception;

public class DuplicateIdException extends Exception {
	public DuplicateIdException(String message){
		super(message);
	}
	public DuplicateIdException(){
		this("�̹� ��ϵ� ȸ���Դϴ�..");
	}
}
