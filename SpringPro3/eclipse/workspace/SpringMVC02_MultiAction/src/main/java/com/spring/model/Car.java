package com.spring.model;

public class Car {
	// field
	private String model;
	private int price;
	
	public Car() {}

	public Car(String model, int price) {
		this.model = model;
		this.price = price;
	}
	
	// setters and getters
	public String getModel() {
		return model;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}
}
