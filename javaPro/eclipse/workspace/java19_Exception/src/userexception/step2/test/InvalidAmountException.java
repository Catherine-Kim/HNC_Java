package userexception.step2.test;

public class InvalidAmountException extends Exception{
	public InvalidAmountException(){
		this("�ܾ��� Ȯ���ϰ� �ٽ� ����ϼ�");
	}
	
	public InvalidAmountException(String message){
		super(message);
	}
}
