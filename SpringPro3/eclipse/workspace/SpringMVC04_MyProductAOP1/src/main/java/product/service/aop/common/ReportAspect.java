package product.service.aop.common;

import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.JoinPoint;

import product.service.aop.model.ReportService;

public class ReportAspect {
	// field
	private ReportService reportService;
	private SqlSession sqlSession;
	
	public ReportAspect() {
		System.out.println("ReportAspect 생성");
	}

	// setter	
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// Method to be woven
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
