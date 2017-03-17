package com.kosta.ship;

public class Boat extends Ship{
	// constructors
	public Boat(){};
	
	public Boat(String shipName, int fuelTank){
		super(shipName, fuelTank);
	}
	
	// overriding sail() and refuel()
	@Override
	public void sail(int dist) {
		int fuelUsed = dist * 10;
		setFuelTank(getFuelTank() - fuelUsed);
	}
	
	@Override
	public void refuel(int fuel) {
		int fuelAdded = fuel * 10;
		setFuelTank(getFuelTank() + fuelAdded);
	}
	
	// toString Overriding
	@Override
	public String toString() {
		return getShipName() + "\t\t" + getFuelTank();
	}
}
