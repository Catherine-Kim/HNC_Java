package com.kosta.ship;

public abstract class Ship {
	// fields
	private String shipName;
	private int fuelTank;

	// constructors
	public Ship(){};
	
	public Ship(String shipName, int fuelTank){
		super();
		this.shipName = shipName;
		this.fuelTank = fuelTank;
	}
	
	// abstract methods
	public abstract void sail(int dist);
	public abstract void refuel(int fuel);
	
	// getters and setters
	public void setShipName(String shipName){
		this.shipName = shipName;
	}
	
	public String getShipName(){
		return shipName;
	}
	
	public void setFuelTank(int fuelTank){
		this.fuelTank = fuelTank;
	}
	
	public int getFuelTank(){
		return fuelTank;
	}
	
	// toString Overriding
	@Override
	public String toString() {
		return shipName + "\t" + fuelTank;
	}
}
