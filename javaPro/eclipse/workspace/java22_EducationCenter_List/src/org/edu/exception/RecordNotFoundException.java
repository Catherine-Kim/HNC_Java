package org.edu.exception;

public class RecordNotFoundException extends Exception{
	// constructors
	public RecordNotFoundException(){
		super("ã���� �ϴ� ����� ����Ʈ�� �������� �ʽ��ϴ�.�Ф�");
	}
	
	public RecordNotFoundException(String someone){
		super(someone + "���� ����Ʈ�� �������� �ʽ��ϴ�.�Ф�");
	}
	
	public RecordNotFoundException(int ssn){
		super("SSN " + ssn + "�� ���� ȸ������ ����Ʈ�� �������� �ʽ��ϴ�.�Ф�");
	}
}
