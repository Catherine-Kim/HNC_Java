package prob.src;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MemberServiceImpl implements MemberService{
	Log log = LogFactory.getLog(getClass());
	
	@Override
	public void register() {
		System.out.println("Register Success");		// Business Logic이라고 치자
		log.info("register member");				// 잘 돌아갔는지 확인하기 위해 Log 출력
		
	}

	@Override
	public void findMemberByID(String id) {
		System.out.println("Member " + id + " Found");		// Business Logic이라고 치자
		log.info("find member - " + id);			// 잘 돌아갔는지 확인하기 위해 Log 출력
	}
}
