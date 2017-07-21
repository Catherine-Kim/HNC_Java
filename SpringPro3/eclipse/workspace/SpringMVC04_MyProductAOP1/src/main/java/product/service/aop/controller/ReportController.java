package product.service.aop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import product.service.aop.model.ReportService;
import product.service.aop.vo.ReportVO;

public class ReportController extends MultiActionController{
	private ReportService reportService;

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	
	public ModelAndView selectReport(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("../../registerProduct", "list", reportService.selectReport());
	}
}
