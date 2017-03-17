package test;

public class StaticExamTest2 {
	int i = 10;			// field
	static int j = 20;	// static variable
	
	public void test(){
		System.out.println("member variable :: " + i);
		System.out.println("static variable :: " + j);
	}
	
	// static �޼ҵ� �ϳ� �߰�
	public static void test2(){
		StaticExamTest2 test = new StaticExamTest2();
		System.out.println("member variable :: " + test.i);
		System.out.println("static variable :: " + j);
	}
	
	public static void main(String[] args) {
		// static ���� ���
		System.out.println(StaticExamTest2.j);
		System.out.println(j);
		
		// member ���� ���
		StaticExamTest2 test2 = new StaticExamTest2();
		System.out.println(test2.i);
		test2.test();
		
	}
}
