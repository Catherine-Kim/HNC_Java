package child;

import parent.Employee;

public class Engineer extends Employee{
	// fields
	private String tech;
	private int bonus;
	
	// constructor
	public Engineer(String empId, String name, String address, int salary, String tech, int bonus) {
		super(empId, name, address, salary);
		this.tech = tech;
		this.bonus = bonus;
	}
	
	// toString() Override
	@Override
	public String toString() {
		return super.toString() + "\t" + tech + "\t" + bonus;
	}

	// getter() / setter()
	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
