package test;

class A{
	public static final int BASIC_SALARY = 3000000;
	public final String test(){
		return "Overriding 금지";
	}
}

final class B{			// 상속 금지
	
}

/*class C extends B{
	
}*/

class D extends A{
	/*public final String test(){
		return "Overriding 금지";
	}*/
}

public class StaticExamTest5 {
	public static void main(String[] args) {
		D d = new D();
		System.out.println("기본급 :: " + d.BASIC_SALARY);
	}
}
