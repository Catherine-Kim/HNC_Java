package kosta.aop.pojo1;

import javax.sql.DataSource;

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
}
