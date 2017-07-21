package product.service.aop.model;

import java.util.List;

import product.service.aop.vo.ReportVO;

public interface ReportService {

	void insertReport(String word);

	void updateReport(String word);

	List<ReportVO> selectReport();

}
