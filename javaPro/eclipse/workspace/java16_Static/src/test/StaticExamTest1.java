package test;

class Member{
	static String name = "�����";
	static int age = 11;
	
	public static void member(){
		System.out.println("��/��/��/�� " + name);
	}
}

public class StaticExamTest1 {
	public static void main(String[] args) {
		Member m = new Member();
		m.member();
		System.out.println(m.age + "��");
	}
}
