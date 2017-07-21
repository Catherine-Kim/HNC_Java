package product.service.aop.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import product.service.aop.model.ReportDAO;
import product.service.aop.vo.ReportVO;

public class ReportDAOImpl implements ReportDAO{
	// field
	private SqlSession sqlSession;
	
	public ReportDAOImpl() {
		System.out.println("ReportDAOImpl 생성");
	}
	
	// setter
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void insertReport(String word) {
		System.out.println(sqlSession.insert("reportMapper.insertReport", word) + 
																		" ROW INSERTED");		
	}

	@Override
	public void updateReport(String word) {
		System.out.println(sqlSession.update("reportMapper.updateReport", word) +
																		" ROW UPDATED");
	}

	@Override
	public List<ReportVO> selectReport() {
		return sqlSession.selectList("reportMapper.selectReport");
	}

}
