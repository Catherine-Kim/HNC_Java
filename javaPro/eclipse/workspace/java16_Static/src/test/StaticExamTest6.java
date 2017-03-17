package test;

class KostaCompany{
	private String name;
	
	// 1. static private���� �ϴ� ��ü �ϳ��� �����ϰ� ��
	static private KostaCompany kosta = new KostaCompany();
	
	// 2. ������ �տ� private�� �ٿ��� �ٸ� ������ ��ü�� �������� ���ϵ��� ��
	private KostaCompany(){
		name = "Kosta";
		System.out.println("Company Name :: " + name);
	}
	
	// 3. public Object Ÿ������ �޼ҵ带 �Ἥ �ٸ� ������ ������ �� �� �ֵ��� ��
	public static KostaCompany getCompany(){
		return kosta;
	}
	
}

public class StaticExamTest6 {
	public static void main(String[] args) {
		// kosta 1, 2, 3�� ��ü �� �� ������
		KostaCompany kosta1 = KostaCompany.getCompany();
		KostaCompany kosta2 = KostaCompany.getCompany();
		KostaCompany kosta3 = KostaCompany.getCompany();
		
		System.out.println(kosta1);
		System.out.println(kosta2);
		System.out.println(kosta3);
	}
}
