package team2.exception;

public class DuplicateModelException extends Exception {
	public DuplicateModelException(String message){
		super(message);
	}
	public DuplicateModelException(){
		this("�̹� ��ϵ� ȸ���Դϴ�..");
	}
}
