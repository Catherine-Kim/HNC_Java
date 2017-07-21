package com.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.spring.model.Car;
import com.spring.model.MockDao;

public class CarController extends AbstractCommandController{
	// field
	private MockDao mockDao;
	
	// constructor
	public CarController() {
		setCommandClass(Car.class);
	}
	
	// setter
	public void setMockDao(MockDao mockDao) {
		this.mockDao = mockDao;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, 
														Object command, BindException e)
																		throws Exception {
		/*
		String model = request.getParameter("model");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Car car = new Car(model, price);
		*/
		Car car = (Car) command;
		String carInfo = mockDao.registerCar(car);
		System.out.println("(Car)command : " + car);
		
		return new ModelAndView("car_result1", "carInfo", carInfo);
	}
}
