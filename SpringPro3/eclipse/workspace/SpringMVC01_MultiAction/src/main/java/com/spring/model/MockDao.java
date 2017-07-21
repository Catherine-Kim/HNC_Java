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
}
