package kosta.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

public class ParamAdvice {
	// field
	Log log = LogFactory.getLog(getClass());
	
	// before 방식
	public void checkParam(JoinPoint jp) throws Throwable{		
		// Target 클래스의 인자값 리턴받기
		Object[] args = jp.getArgs();
		
		// 인자값이 안 들어간 경우
		for(Object o : args){
			if((o == null) || (o.equals(""))){		// 혹시라도 null로 안 걸러질까봐
				String targetCName = jp.getClass().getName();
				String targetMName = jp.getSignature().getName();
				
				log.warn("[WARNING] 인자값이 부적합합니당 - " + 
													targetMName + " from " + targetCName);
			}
		}
	}
}
