package overloading.solv.step2.test;


class Worker{
	public void drink(){
		System.out.println("drinking...");
	}
	
	public void drink(int cup){
		System.out.println("beer " + cup +" cup drinking...");
	}
	
	public String drink(String who, int cup){
		return "Had " + cup + " cups with " + who;
	}

}

public class OverloadingMethodTest2 {

	public static void main(String[] args) {
		Worker w = new Worker();
		
		w.drink();
		w.drink(13);
		System.out.println(w.drink("Á¤±¹", 30));
	}

}
