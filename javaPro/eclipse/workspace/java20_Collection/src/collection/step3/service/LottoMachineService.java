package collection.step3.service;

import java.util.TreeSet;

public class LottoMachineService {
	
	
	public TreeSet createLottoNumber(){
		TreeSet<Integer> set = new TreeSet<Integer>();

		while(set.size() < 6){
			set.add((int)(Math.random() * 45 + 1));
		}
		return set;
	}
}
