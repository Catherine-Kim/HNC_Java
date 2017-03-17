package com.kosta.ship;

public class Cruise extends Ship{
	// constructors
	public Cruise(){};
	
	public Cruise(String shipName, int fuelTank){
		super(shipName, fuelTank);
	}
	
	// overriding sail() and refuel()
	@Override
	public void sail(int dist) {
		int fuelUsed = dist * 13;
		setFuelTank(getFuelTank() - fuelUsed);
	}
	
	@Override
	public void refuel(int fuel) {
		int fuelAdded = fuel * 8;
		setFuelTank(getFuelTank() + fuelAdded);
	}
}
