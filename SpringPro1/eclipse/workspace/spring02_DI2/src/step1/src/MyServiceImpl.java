package step1.src;

public class MyServiceImpl implements MyService{
	private String msg;
	
	public MyServiceImpl(String msg) {
		this.msg = msg;
		System.out.println("Bean ��ü�� ������");
	}
	
	@Override
	public String pringMsg() {
		
		return msg;
	}
}
