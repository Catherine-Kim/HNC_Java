package overloading.prob.step1.test;

class Worker{
	public void drink(){
		System.out.println("I'm drinking..");
	}
	
	public void beerDrinking(int jan){
		System.out.println("beer " + jan +"cup drinking...");
	}
	
	public String withDrink(String who, int cup){
		return "Had " + cup + " cups with " + who;
	}
}

public class OverloadingMethodTest1 {
	public static void main(String[] args) {
		/* 
		 * 1. Working 객체 생성
		 * 2. Working 객체의 기능을 차례로 호출해서  콘솔창에 출력해보셈
		 */
		Worker w = new Worker();
		
		w.drink();
		w.beerDrinking(13);
		System.out.println(w.withDrink("정국", 30));
	}
}
