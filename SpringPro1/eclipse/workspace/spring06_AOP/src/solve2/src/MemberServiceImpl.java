package solve2.src;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MemberServiceImpl implements MemberService{
	
	@Override
	public void register() {
		System.out.println("Register Success");		// Business Logic�̶�� ġ��=
		
	}

	@Override
	public String findMemberByID(String id) {
		System.out.println("Member " + id + " Found");		// Business Logic�̶�� ġ��
		return id;
	}
}
