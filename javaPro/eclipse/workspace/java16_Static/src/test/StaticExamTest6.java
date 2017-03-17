package test;

class KostaCompany{
	private String name;
	
	// 1. static private으로 일단 객체 하나를 생성하고 봄
	static private KostaCompany kosta = new KostaCompany();
	
	// 2. 생성자 앞에 private을 붙여서 다른 곳에서 객체를 생성하지 못하도록 함
	private KostaCompany(){
		name = "Kosta";
		System.out.println("Company Name :: " + name);
	}
	
	// 3. public Object 타입으로 메소드를 써서 다른 곳에서 가져다 쓸 수 있도록 함
	public static KostaCompany getCompany(){
		return kosta;
	}
	
}

public class StaticExamTest6 {
	public static void main(String[] args) {
		// kosta 1, 2, 3로 객체 세 개 만들어봐
		KostaCompany kosta1 = KostaCompany.getCompany();
		KostaCompany kosta2 = KostaCompany.getCompany();
		KostaCompany kosta3 = KostaCompany.getCompany();
		
		System.out.println(kosta1);
		System.out.println(kosta2);
		System.out.println(kosta3);
	}
}
