package kosta.aop.pojo3;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberDAOImpl implements MemberDAO{
	// field
	@Autowired
	private String dataSource;
	
	@Override
	public void register() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[SUCCESS] register() from MemberDAOImpl");
		System.out.println(dataSource);
	}
	
	public String findById(String id){
		return "[SUCCESS] findById() from MemberDAOImpl";
	}

	@Override
	public void update() {
		System.out.println("[SUCCESS] update() from MemberDAOImpl");		
	}
}
