package step2.src;

public class UserDAOImpl implements UserDAO{
	@Override
	public void register(String name) {
		System.out.println("member : " + name);
		System.out.println("User Register... " + name);
		member();
	}
	
	public String member(){
		return "member";
	}
}
