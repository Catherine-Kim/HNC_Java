package solve2.src;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MemberServiceImpl implements MemberService{
	
	@Override
	public void register() {
		System.out.println("Register Success");		// Business Logic이라고 치자=
		
	}

	@Override
	public String findMemberByID(String id) {
		System.out.println("Member " + id + " Found");		// Business Logic이라고 치자
		return id;
	}
}
