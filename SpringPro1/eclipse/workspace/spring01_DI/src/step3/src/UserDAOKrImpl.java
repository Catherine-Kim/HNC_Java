package step3.src;

public class UserDAOKrImpl implements UserDAO{
	public UserDAOKrImpl() {
		System.out.println("[Constructor] Creating UserDAOKrImpl");
	}
	
	@Override
	public void sayHelloMemeber(String message) {
		System.out.println("¾È³ó " + message);	
	}
}
