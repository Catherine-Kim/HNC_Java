package test;

class A{
	public static final int BASIC_SALARY = 3000000;
	public final String test(){
		return "Overriding ����";
	}
}

final class B{			// ��� ����
	
}

/*class C extends B{
	
}*/

class D extends A{
	/*public final String test(){
		return "Overriding ����";
	}*/
}

public class StaticExamTest5 {
	public static void main(String[] args) {
		D d = new D();
		System.out.println("�⺻�� :: " + d.BASIC_SALARY);
	}
}
