package step2.src;

public class MyServiceImpl implements MyService{
	private String msg;
	
	// field �� �� �� �߰�
	private int price;
	private String name;
	
	public MyServiceImpl(String msg) {
		this.msg = msg;
		System.out.println("Bean ��ü�� ������");
	}
	
	@Override
	public String pringMsg() {
		
		return msg;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDetails(){
		return name + " | " + price;
	}
}
