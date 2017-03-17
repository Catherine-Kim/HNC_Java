package fly.test;

// 기능의 template
interface Flyer{
	void fly();	// public abstract void fly(); 와 동일한 표현
	void land();
	public abstract String take_off();
}

class Bird implements Flyer{
	@Override
	public void fly() {
		System.out.println("A bird is flying..");
	}
	
	@Override
	public void land() {
		System.out.println("A bird is landing..");
	}
	
	@Override
	public String take_off() {
		return "A bird is taking off the ground..";
	}
	
	// 추가
	public void layEggs(){
		System.out.println("A bird is laying eggs..");
	}
}

class Superman implements Flyer{
	@Override
	public void fly() {
		System.out.println("Superman is flying..");
	}
	
	@Override
	public void land() {
		System.out.println("Superman is landing..");		
	}
	
	@Override
	public String take_off() {
		return "Superman taking off..";
	}
	
	//추가
	public void stop_bullet(){
		System.out.println("Superman is stopping the bullet..");
	}
}

public class FlyerTest1 {
	public static void main(String[] args) {
		Flyer f1 = new Bird();
		Flyer f2 = new Superman();
		
		f1.fly();
		f2.fly();
		
		Superman sm = (Superman)f2;
		System.out.println(sm.take_off());
	}
}
