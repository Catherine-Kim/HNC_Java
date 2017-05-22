package step1.src;

public class MyServiceImpl implements MyService{
	private String msg;
	
	public MyServiceImpl(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String pringMsg() {
		
		return msg;
	}
}
