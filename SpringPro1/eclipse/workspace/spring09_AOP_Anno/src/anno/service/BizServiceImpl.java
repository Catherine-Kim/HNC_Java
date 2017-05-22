package anno.service;

import org.springframework.beans.factory.annotation.Autowired;

public class BizServiceImpl implements BizService{
	// field
	@Autowired
	String dataSource;		// setter∑Œ ¡÷¿‘

	@Override
	public void register() {
		System.out.println("[SUCCESS] register() from BizServiceImpl");
	}

	@Override
	public String findMemberId() {
		System.out.println("[SUCCESS] findMemberId() from BizServiceImpl");
		return "ID : KOSTA";
	}
}
