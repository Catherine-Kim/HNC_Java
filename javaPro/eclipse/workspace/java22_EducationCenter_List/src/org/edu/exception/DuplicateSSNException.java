package org.edu.exception;

public class DuplicateSSNException extends Exception{
	// constructors
	public DuplicateSSNException(){
		super("�̹� ���� �̸��� ����� ����Ʈ�� �����մϴ�.�Ф�");
	}
	
	public DuplicateSSNException(String someone){
		super(someone + "���� �̹� ����Ʈ�� �����մϴ�.�Ф�");
	}
}
