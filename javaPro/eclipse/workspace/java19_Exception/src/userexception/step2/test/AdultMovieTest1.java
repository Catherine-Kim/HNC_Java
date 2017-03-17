package userexception.step2.test;

import java.util.Scanner;

class UnderAgeException extends Exception{
	UnderAgeException(){
		this("미성년자 금지");
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
			System.out.println("성인영화 관람 가능. 티켓팅 시작..");
		}
	}
}

public class AdultMovieTest1 {
	public static void main(String[] args) {
		AdultMovie am = new AdultMovie();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("여기는 CGV..");
		System.out.println("고객님의 나이를 입력하세요.");
		System.out.print("나이 :: ");
		
		int age = sc.nextInt();
		try {
			am.entrance(age);
		} catch (UnderAgeException e) {
			System.out.println(e.getMessage());
		}
	}
}
