package step3.mvc.exception;

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException(String message){
		super(message);
	}
	public RecordNotFoundException(){
		this("�׷� ���̵� ���� ȸ�� ���..");
	}
}
