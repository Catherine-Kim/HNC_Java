package team2.exception;

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException(String message){
		super(message);
	}
	public RecordNotFoundException(){
		this("�׷� ���̵� ���� ȸ�� ���..");
	}
}
