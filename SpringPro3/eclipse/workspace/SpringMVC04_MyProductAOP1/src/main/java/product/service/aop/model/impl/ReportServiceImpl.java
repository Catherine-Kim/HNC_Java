package product.service.aop.model.impl;

import java.util.List;

import product.service.aop.model.ReportDAO;
import product.service.aop.model.ReportService;
import product.service.aop.vo.ReportVO;

public class ReportServiceImpl implements ReportService{
	// field
	private ReportDAO reportDAO;
	
	public ReportServiceImpl() {
		System.out.println("ReportServiceImpl 생성");
	}

	// setter
	public void setReportDAO(ReportDAO reportDAO) {
		this.reportDAO = reportDAO;
	}

	@Override
	public void insertReport(String word) {
		reportDAO.insertReport(word);
	}

	@Override
	public void updateReport(String word) {
		reportDAO.updateReport(word);		
	}

	@Override
	public List<ReportVO> selectReport() {
		return reportDAO.selectReport();
	}
	
}
