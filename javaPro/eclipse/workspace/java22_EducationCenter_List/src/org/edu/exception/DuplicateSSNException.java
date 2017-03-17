package org.edu.exception;

public class DuplicateSSNException extends Exception{
	// constructors
	public DuplicateSSNException(){
		super("이미 같은 이름의 사람이 리스트에 존재합니다.ㅠㅠ");
	}
	
	public DuplicateSSNException(String someone){
		super(someone + "님은 이미 리스트에 존재합니다.ㅠㅠ");
	}
}
