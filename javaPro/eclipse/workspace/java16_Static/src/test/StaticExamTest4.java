package test;

public class StaticExamTest4 {
	static int i;
	public static void main(String[] args) {
		System.out.println("main method static block .. " + i);
		
	}
	
	// static block
	static{
		System.out.println("static initialization block... " + ++i);
	};
}
