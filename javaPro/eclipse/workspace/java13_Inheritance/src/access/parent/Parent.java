package access.parent;

public class Parent {
	public String publicField = "publicField";
	protected String protectedField = "protectedField";
	private String privateField = "privateField";
	String defaultField = " defaultField";
	
	public Parent(){};
	// �������� ���������ڴ� Ŭ������ ���������ڿ� �����ؾ���
	
	public void access(){
		System.out.println("Access Modifier Test ::");
		
	}
}
