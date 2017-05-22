package logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogService {
	private Log log = LogFactory.getLog(getClass());
	
	public void testLog(){
		log.trace("trace message..");		// ���� ������ ���
		log.debug("debug message..");		// �� ���� ���
		log.info("info message..");			// ���� ���
		log.warn("warn message..");			// �� ����� ��������
		log.error("error message..");		// warn ���� ����
		log.fatal("fatal message..");		// �մ� �� ���� ������ ������ ��Ȳ
	}
}
