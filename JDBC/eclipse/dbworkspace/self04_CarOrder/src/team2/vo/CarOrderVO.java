package team2.vo;

import java.util.ArrayList;

public class CarOrderVO {
	// fields
	private CarVO car;
	private int count;
	
	// constructors
	public CarOrderVO(){}	
	
	public CarOrderVO(CarVO car, int count) {
		super();
		this.count = count;
		this.car = car;
	}
	
	// getters and setters
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public CarVO getCar() {
		return car;
	}

	public void setCar(CarVO car) {
		this.car = car;
	};
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return car + "\t" + count;
	}	
}
