package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

public class DiceBImpl implements Dice{
	// field
	private int value;
	
	// constructor
	public DiceBImpl() {
		System.out.println("[Constructor] " + getClass().getName());	// 클래스의 FQCN
	}
	
	// setter and getter
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public void selectedNumber() {
		value = new Random().nextInt(6) + 1;		
	}
}
