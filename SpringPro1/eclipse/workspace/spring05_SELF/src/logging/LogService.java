package logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogService {
	private Log log = LogFactory.getLog(getClass());
	
	public void testLog(){
		log.trace("trace message..");		// 가장 안전한 방법
		log.debug("debug message..");		// 그 다음 방법
		log.info("info message..");			// 정보 출력
		log.warn("warn message..");			// 이 담부터 위험해짐
		log.error("error message..");		// warn 보다 위험
		log.fatal("fatal message..");		// 손댈 수 없을 정도로 위험한 상황
	}
}
