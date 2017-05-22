package prob.src;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MemberServiceImpl implements MemberService{
	Log log = LogFactory.getLog(getClass());
	
	@Override
	public void register() {
		System.out.println("Register Success");		// Business Logic�̶�� ġ��
		log.info("register member");				// �� ���ư����� Ȯ���ϱ� ���� Log ���
		
	}

	@Override
	public void findMemberByID(String id) {
		System.out.println("Member " + id + " Found");		// Business Logic�̶�� ġ��
		log.info("find member - " + id);			// �� ���ư����� Ȯ���ϱ� ���� Log ���
	}
}
