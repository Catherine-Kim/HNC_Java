package kosta.aop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAdvice {
	BufferedWriter bw;
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis();
		String targetMName = pjp.getSignature().getName();
		DateFormat f = DateFormat.getInstance();
		
		logging("[" + targetMName + "] 메소드 호출 - " + f.format(start));
		Object retObj = pjp.proceed();
		
		long end = System.currentTimeMillis();
		logging("[" + targetMName + "] 메소드 완료 - " + f.format(end));
		logging("[" + targetMName + "] 메소드 소요 시간 - " + (end-start)/1000 + "초");
		return retObj;
	}

	private void logging(String message) {
		// 인자로 받은 String을 file로 뿌릴 것
		try {
			bw = new BufferedWriter(new FileWriter("src/kosta/test/Loggingadvice.txt", true));
			// 두 번째 인자값 true의 의미 : 이어쓰기(true가 아니면 덮어쓰기됨)
			bw.flush();
			bw.write(message);
			bw.newLine();		// 다음 메세지는 다음 줄에 써질 수 있도록 함
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
