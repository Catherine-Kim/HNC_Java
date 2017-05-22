package step3.src;

public class UserDAOEnImpl implements UserDAO{
	public UserDAOEnImpl() {
		System.out.println("[Constructor] Creating UserDAOEnImpl");
	}
	
	@Override
	public void sayHelloMemeber(String message) {
		System.out.println("Hello " + message);	
	}
}
