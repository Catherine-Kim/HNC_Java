package broker.exception;

public class RecordNotFoundException extends Exception{
	public RecordNotFoundException(){
		this("�׷� �� �����ϴ�...");
	}
	
	public RecordNotFoundException(String message){
		super(message);
	}
}
