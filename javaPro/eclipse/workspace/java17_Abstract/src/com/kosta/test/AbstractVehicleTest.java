package com.kosta.test;

import java.util.Vector;
import com.kosta.ship.Boat;
import com.kosta.ship.Cruise;
import com.kosta.ship.Ship;

public class AbstractVehicleTest {
	public static void main(String[] args) {
		// Initialization
		Vector<Ship> shipList = new Vector<Ship>();
		
		shipList.add(new Boat("Boat01", 500));
		shipList.add(new Cruise("Cruise01", 1000));
		
		// before sail
		System.out.println("shipName\tfuelTank");
		System.out.println("-----------------------------------");
		for(Ship s : shipList){
			System.out.println(s);
		}
		
		// sail 10
		System.out.println("\n10 운항");
		System.out.println("shipName\tfuelTank");
		System.out.println("-----------------------------------");
		for(Ship s : shipList){
			s.sail(10);
		}
		for(Ship s : shipList){
			System.out.println(s);
		}
		
		// refuel 50
		System.out.println("\n50 운항");
		System.out.println("shipName\tfuelTank");
		System.out.println("-----------------------------------");
		for(Ship s : shipList){
			s.refuel(50);
		}
		for(Ship s : shipList){
			System.out.println(s);
		}
	}
}
