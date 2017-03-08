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
		 * 1. Working ��ü ����
		 * 2. Working ��ü�� ����� ���ʷ� ȣ���ؼ�  �ܼ�â�� ����غ���
		 */
		Worker w = new Worker();
		
		w.drink();
		w.beerDrinking(13);
		System.out.println(w.withDrink("����", 30));
	}
}
