package spring.service.dice.play;

import spring.service.dice.Dice;

public class Player02 {
	// field 
	private Dice dice;
	private int totalValue;
	
	// constructor
	public Player02() {	}
	
	public Player02(Dice dice) {
		this.dice = dice;
	}
	
	// getter and setter
	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	// method
	public void playDice(int count){
		System.out.println("==>"+getClass().getName()+".playDice() start....");

		for (int i = 0; i < count; i++) {
			dice.selectedNumber();
			System.out.println("::[ "+dice.getClass().getName()+" ] 의 선택된수 : " + 
																		dice.getValue());
			totalValue += dice.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}
}//end of class