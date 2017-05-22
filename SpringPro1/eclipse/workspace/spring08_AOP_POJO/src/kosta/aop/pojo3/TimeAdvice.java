package kosta.aop.pojo3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


public class TimeAdvice {

	public void time(ProceedingJoinPoint pjp) throws Throwable{
		
		long start = System.currentTimeMillis();
		String mName = pjp.getSignature().getName();
		
		System.out.println("[START] " + mName + "() - " + start);
		System.out.println(pjp.proceed());
		
		long end = System.currentTimeMillis();
		System.out.println("[END] " + mName + "() - " + start);
		System.out.println("[TIME] Total Time Taken :: " + (end-start)/1000 + "√ ");
	}
}
