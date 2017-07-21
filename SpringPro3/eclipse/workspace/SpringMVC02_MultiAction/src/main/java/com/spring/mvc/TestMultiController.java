package com.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.model.Car;
import com.spring.model.MockDao;

public class TestMultiController extends MultiActionController{
	// field
	private MockDao mockDao;
	
	// setter
	public void setMockDao(MockDao mockDao) {
		this.mockDao = mockDao;
	}

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response){
		System.out.println("[Delete Request] TestMultiController - delete()");
		
		return new ModelAndView("delete_result", "message", mockDao.delete());
	}
	
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response){
		System.out.println("[Update Request] TestMultiController - update()");
		return new ModelAndView("update_result", "message", mockDao.update());
	}
	
	// 추가
	public ModelAndView registerCar(HttpServletRequest request, 
											HttpServletResponse response, Car car){
		System.out.println("car from registerCar() from TestMultiAction ::");
		System.out.println(car);
		return new ModelAndView("car_result2", "carInfo", mockDao.registerCar(car));
	}
}
