package overloading.constructor.step3.test;

class Worker{
	String name;
	String dept; // department
	int ssn;
	
	Worker(){}

	public Worker(String name, String dept, int ssn) {
		this.name = name;
		this.dept = dept;
		this.ssn = ssn;
	}
	
	public Worker(int ssn){
		this.ssn = ssn;
	}
	
	public void drink(){
		System.out.println("drinking...");
	}
	
	public void drink(int cup){
		System.out.println("beer " + cup +" cup drinking...");
	}
	
	public String drink(String who, int cup){
		return "Had " + cup + " cups with " + who;
	}
	
	// drink를 제외하고 기능 하나 더 추가 - 출력 기능 추가
	public String getWorkerInfo(){
		return name+"\t" + dept + "\t" + ssn;
	}
}

public class OverloadingConstructorTest3 {

	public static void main(String[] args) {
		Worker w = new Worker();
		
		w.drink();
		w.drink(13);
		System.out.println(w.drink("정국", 30));
		
		System.out.println("\n---------------------------Worker 1---------------------------");
		Worker worker1 = new Worker("James", "IT", 1212);
		worker1.drink(3);
		System.out.println(worker1.getWorkerInfo());
		System.out.println("\n---------------------------Worker 2---------------------------");
		Worker worker2 = new Worker(4444);
		worker1.drink(3);
		System.out.println(worker2.getWorkerInfo());
	}

}
