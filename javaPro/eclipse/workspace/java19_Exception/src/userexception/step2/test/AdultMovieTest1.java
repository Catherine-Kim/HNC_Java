package userexception.step2.test;

import java.util.Scanner;

class UnderAgeException extends Exception{
	UnderAgeException(){
		this("�̼����� ����");
	}

	UnderAgeException(String s){
		super(s);
	}
}

class AdultMovie{
	public void entrance(int age) throws UnderAgeException{
		if(age < 19){
			throw new UnderAgeException();
		}else{
			System.out.println("���ο�ȭ ���� ����. Ƽ���� ����..");
		}
	}
}

public class AdultMovieTest1 {
	public static void main(String[] args) {
		AdultMovie am = new AdultMovie();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("����� CGV..");
		System.out.println("������ ���̸� �Է��ϼ���.");
		System.out.print("���� :: ");
		
		int age = sc.nextInt();
		try {
			am.entrance(age);
		} catch (UnderAgeException e) {
			System.out.println(e.getMessage());
		}
	}
}
