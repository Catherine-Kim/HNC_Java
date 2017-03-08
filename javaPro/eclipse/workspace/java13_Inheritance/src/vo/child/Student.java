package vo.child;

import vo.parent.Person;

public class Student extends Person{
	private int score;
	private int DEFAULT_SCORE = 0;
	
	public Student(){
		super();
		this.score = DEFAULT_SCORE;
	}
	
	public Student(String name, int ssn, String address, int score){
		super(name, ssn, address);
		this.score = score;
	}
	
	public int getScore(){
		return score;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t" + score;
	}
}
