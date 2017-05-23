package kosta.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

public class ParamAdvice {
	// field
	Log log = LogFactory.getLog(getClass());
	
	// before ���
	public void checkParam(JoinPoint jp) throws Throwable{		
		// Target Ŭ������ ���ڰ� ���Ϲޱ�
		Object[] args = jp.getArgs();
		
		// ���ڰ��� �� �� ���
		for(Object o : args){
			if((o == null) || (o.equals(""))){		// Ȥ�ö� null�� �� �ɷ������
				String targetCName = jp.getClass().getName();
				String targetMName = jp.getSignature().getName();
				
				log.warn("[WARNING] ���ڰ��� �������մϴ� - " + 
													targetMName + " from " + targetCName);
			}
		}
	}
}
