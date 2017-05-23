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
		
		logging("[" + targetMName + "] �޼ҵ� ȣ�� - " + f.format(start));
		Object retObj = pjp.proceed();
		
		long end = System.currentTimeMillis();
		logging("[" + targetMName + "] �޼ҵ� �Ϸ� - " + f.format(end));
		logging("[" + targetMName + "] �޼ҵ� �ҿ� �ð� - " + (end-start)/1000 + "��");
		return retObj;
	}

	private void logging(String message) {
		// ���ڷ� ���� String�� file�� �Ѹ� ��
		try {
			bw = new BufferedWriter(new FileWriter("src/kosta/test/Loggingadvice.txt", true));
			// �� ��° ���ڰ� true�� �ǹ� : �̾��(true�� �ƴϸ� ������)
			bw.flush();
			bw.write(message);
			bw.newLine();		// ���� �޼����� ���� �ٿ� ���� �� �ֵ��� ��
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
