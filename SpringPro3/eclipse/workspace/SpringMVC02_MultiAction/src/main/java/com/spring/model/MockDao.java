package com.spring.model;

public class MockDao {
	public String update(){
		String message = "[SUCCESS] update() from MockDao";
		System.out.println(message);
		return message;
	}
	
	public String delete(){
		String message = "[SUCCESS] delete() from MockDao";
		System.out.println(message);
		return message;
	}
	
	// 추가
	public String registerCar(Car car){
		System.out.println("Car Register :: " + car);
		return "자동차 등록 성공 :: " + car.getModel();
	}
}
