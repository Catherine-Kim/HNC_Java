package collection.step2.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import collection.step2.vo.CustomerVO;

public class CustomerVOMapTest {
	public static void main(String[] args) {
		// to-do 1
		Map<Integer, CustomerVO> map = new HashMap<Integer, CustomerVO>();
		
		map.put(111, new CustomerVO("Kate", 31, 111));
		map.put(222, new CustomerVO("Lauren", 23, 222));
		map.put(333, new CustomerVO("Steve", 29, 333));
		map.put(444, new CustomerVO("Penny", 28, 444));
		map.put(555, new CustomerVO("Charles", 25, 555));
		map.put(666, new CustomerVO("John", 25, 666));
		map.put(777, new CustomerVO("Josh", 34, 777));
		map.put(888, new CustomerVO("Brad", 20, 888));
		map.put(999, new CustomerVO("Chris", 27, 999));
		
		// key가 222인 Customer의 정보 출력
		System.out.println("key가 222인 Customer : " + map.get(222));
		
		// custId가 111인 객체 찾아서 그 사람의 이름 출력		// keySet ver.
		System.out.println("\nId가 111인 Customer의 이름 : " + map.get(111).getName());
		Set<Integer> set = map.keySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()){
			int temp = (Integer)it.next();
			CustomerVO tempCus = map.get(temp);
			if(tempCus.getCustId() == 111){
				System.out.println("\nId가 111인 Customer의 이름 : " + tempCus.getName());
				break;
			}
		}
		
		// map에 들어있는 모든 key 출력
		System.out.println("\nmap에 들어있는 모든 key : " + set);			
		
		// map에 들어있는 모든 사람들의 나이의 평균 구하기
		int sum = 0;
		int avg = 0;
		for(int i : set){
			sum += map.get(i).getAge();
		}
		avg = sum/map.size();
		System.out.println("\nmap에 들어있는 모든 사람들의 나이의 평균 : " + avg);
		
		// map에 들어있는 모든 key 출력 - teacher ver. 1
		sum = 0;
		Iterator ite = set.iterator();
		while(ite.hasNext()){
			int key = (int)ite.next();
			CustomerVO cusst = (CustomerVO)map.get(key);
			sum += cusst.getAge();
		}
		avg = sum/map.size();
		System.out.println("\nmap에 들어있는 모든 사람들의 나이의 평균 : " + avg);
		
		//  map에 들어있는 모든 key 출력 - teacher ver. 2
		sum = 0;
		Collection<CustomerVO> c = map.values();
		Iterator<CustomerVO> iter = c.iterator();
		while(iter.hasNext()){
			sum += iter.next().getAge();
		}
		avg = sum/map.size();
		System.out.println("\nmap에 들어있는 모든 사람들의 나이의 평균 : " + avg);
	}
}
