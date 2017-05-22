package self4;

import java.util.HashMap;
import java.util.Iterator;

public class House implements Residence{
	// field 
	private String address;
	private HashMap<String, HomeAppliance> hp;
	
	// constructor
	public House(HashMap<String, HomeAppliance> hp) {
		this.hp = hp;
	}

	// getter & setter
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public HashMap<String, HomeAppliance> getHp() {
		return hp;
	}

	public void setHp(HashMap<String, HomeAppliance> hp) {
		this.hp = hp;
	}

	@Override
	public void reside() {
		System.out.println("House :: " + address);
		System.out.println("- Home Appliance :: ");
		Iterator<String> it = hp.keySet().iterator();
		while(it.hasNext()){
			System.out.println(hp.get(it.next()));
		}
	}
}
