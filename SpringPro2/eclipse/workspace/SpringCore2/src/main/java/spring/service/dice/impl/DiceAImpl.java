package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

public class DiceAImpl implements Dice{
	// field
	private int value;
	
	// constructor
	public DiceAImpl() {
		System.out.println("[Constructor] " + getClass().getName());	// Ŭ������ FQCN
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
