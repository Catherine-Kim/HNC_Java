package collection.step3.test;

import java.util.TreeSet;

import collection.step3.service.LottoMachineService;

public class LottoMachineTest {
	public static void main(String[] args) {
		LottoMachineService service = new LottoMachineService();
		TreeSet tset = service.createLottoNumber();
	
		System.out.println("로또 번호 : " + tset);
	}
}
