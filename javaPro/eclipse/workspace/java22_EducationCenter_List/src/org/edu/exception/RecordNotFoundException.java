package org.edu.exception;

public class RecordNotFoundException extends Exception{
	// constructors
	public RecordNotFoundException(){
		super("찾고자 하는 사람이 리스트에 존재하지 않습니다.ㅠㅠ");
	}
	
	public RecordNotFoundException(String someone){
		super(someone + "님은 리스트에 존재하지 않습니다.ㅠㅠ");
	}
	
	public RecordNotFoundException(int ssn){
		super("SSN " + ssn + "을 가진 회원님은 리스트에 존재하지 않습니다.ㅠㅠ");
	}
}
