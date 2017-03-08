package total.step3.test;

// Simple Operator Code

public class OperatorExamTest {

	public static void main(String[] args) {
		// Variable Declaration
		// field는 클래스 안에 선언되어 있음
		// 변수 선언은 메소드 안에서만 하기 때문에 이 변수는 해당 메소드 안에서만 쓸 수 있음
		// 메소드 안에서 선언된 변수 : Local Variable(지역 변수)
		// field와는 완전히 다르다 -> 변수가 선언된 위치는 아주 중요
		
		int i = 5; 
		int j = 3;
		
		System.out.println("i%j : " + i%j);
		
		// Operator에 접근해서 그 안의 메소드를 쓰고 싶어
		// 객체 생성 ㄱ
		
		Operator o = new Operator();
		Operator o2 = new Operator();
		
		// o와 o2는 다른 객체 -> 각각 다른 주소값을 가짐
		
		System.out.println("o의 주소값 : " + o);
		System.out.println("o2의 주소값 : " + o2);
		System.out.println("o==o2 : " + (o==o2));
		
		// 주소값이 다르다면 서로 다른 객체임을 확인할 수 있지
		
		o = o2;
		// o의 주소값 == o2의 주소값
		
		System.out.println("o = o2 를 한 후 ::");
		
		System.out.println("o의 주소값 : " + o);
		System.out.println("o2의 주소값 : " + o2);
		System.out.println("o==o2 : " + (o==o2));
		
		boolean flag = false;
		
		System.out.println(flag);
		System.out.println(!flag);
		
		int k = 10;
		
		System.out.println(k++);
		System.out.println(k);
		
		int m = 10;
		
		System.out.println(++m);
		
		int balance = 10000;
		balance -= 5000;
		System.out.println(balance);
		
		System.out.println(o.test1() && o.test2());
	}

}

class Operator{
	public boolean test1(){
		System.out.println("test1() calling...");
		return true;
	}
	
	public boolean test2(){
		System.out.println("test2() calling...");
		return false;
	}
}