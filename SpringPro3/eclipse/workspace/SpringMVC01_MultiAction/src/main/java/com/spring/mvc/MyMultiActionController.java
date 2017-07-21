package com.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MyMultiActionController extends MultiActionController {
	// UpdateController
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		// 이 메소드명 update는 꼭 지켜야 함

		// Business Logic 했다 치고
		System.out.println("[Update Request] MultiActionController - update()");
		
		return new ModelAndView("update_result", "info", "Update OK!!");
	}
	
	// DeleteController
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
		// 이 메소드명 delete는 꼭 지켜야 함

		// Business Logic 했다 치고
		System.out.println("[Delete Request] MultiActionController - delete()");
		
		return new ModelAndView("delete_result", "info", "Delete OK!!");
	}
}
