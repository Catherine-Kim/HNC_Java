package access.parent;

public class Parent {
	public String publicField = "publicField";
	protected String protectedField = "protectedField";
	private String privateField = "privateField";
	String defaultField = " defaultField";
	
	public Parent(){};
	// 생성자의 접근지정자는 클래스의 접근지정자와 동일해야함
	
	public void access(){
		System.out.println("Access Modifier Test ::");
		
	}
}
