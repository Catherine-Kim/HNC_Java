package anno.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BizAdvice {
	@Before("execution(* anno..*())")
	public void beforeMethod(JoinPoint jp) throws Throwable{
		SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
		System.out.println("[BizAdvice] Target Method : " + jp.getSignature().getName() + 
																	" from beforeMethod");
		System.out.println("[BizAdvice] Today is " + f.format(new Date()) + 
																	" from beforeMethod");
	}
}
