package broker.exception;

public class InvalidTransactionException extends Exception{
	public InvalidTransactionException(){
		this("������ �ִ� �ֽĺ��� �ȷ��� �ֽ��� �� ���ƿ�..");
	}
	
	public InvalidTransactionException(String message){
		super(message);
	}
}
