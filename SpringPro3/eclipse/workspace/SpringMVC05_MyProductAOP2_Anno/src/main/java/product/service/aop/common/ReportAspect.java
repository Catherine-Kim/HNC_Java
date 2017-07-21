package product.service.aop.common;

import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import product.service.aop.model.ReportService;

@Aspect
public class ReportAspect {
	// field
	@Autowired
	private ReportService reportService;
	@Autowired
	private SqlSession sqlSession;
	
	public ReportAspect() {
		System.out.println("ReportAspect 생성");
	}

	// Method to be woven
	@Around("execution(* product.service.model.*Service.find*(..))")
	public void report(JoinPoint jp) throws Throwable{
		// Target의 select문을 수행한 결과들(검색한 상품들)
		Object[] args = jp.getArgs();
		String word = (String) args[0];
		System.out.println("word from ReportAspect :: " + word);
		
		int row = sqlSession.selectOne("reportMapper.selectCount", word);
		System.out.println("row from ReportAspect :: " + row);
		
		if(row == 0){
			reportService.insertReport(word);
		}else{
			reportService.updateReport(word);
		}
	}
}
