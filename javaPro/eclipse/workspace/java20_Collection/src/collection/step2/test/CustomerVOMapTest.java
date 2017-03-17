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
		
		// key�� 222�� Customer�� ���� ���
		System.out.println("key�� 222�� Customer : " + map.get(222));
		
		// custId�� 111�� ��ü ã�Ƽ� �� ����� �̸� ���		// keySet ver.
		System.out.println("\nId�� 111�� Customer�� �̸� : " + map.get(111).getName());
		Set<Integer> set = map.keySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()){
			int temp = (Integer)it.next();
			CustomerVO tempCus = map.get(temp);
			if(tempCus.getCustId() == 111){
				System.out.println("\nId�� 111�� Customer�� �̸� : " + tempCus.getName());
				break;
			}
		}
		
		// map�� ����ִ� ��� key ���
		System.out.println("\nmap�� ����ִ� ��� key : " + set);			
		
		// map�� ����ִ� ��� ������� ������ ��� ���ϱ�
		int sum = 0;
		int avg = 0;
		for(int i : set){
			sum += map.get(i).getAge();
		}
		avg = sum/map.size();
		System.out.println("\nmap�� ����ִ� ��� ������� ������ ��� : " + avg);
		
		// map�� ����ִ� ��� key ��� - teacher ver. 1
		sum = 0;
		Iterator ite = set.iterator();
		while(ite.hasNext()){
			int key = (int)ite.next();
			CustomerVO cusst = (CustomerVO)map.get(key);
			sum += cusst.getAge();
		}
		avg = sum/map.size();
		System.out.println("\nmap�� ����ִ� ��� ������� ������ ��� : " + avg);
		
		//  map�� ����ִ� ��� key ��� - teacher ver. 2
		sum = 0;
		Collection<CustomerVO> c = map.values();
		Iterator<CustomerVO> iter = c.iterator();
		while(iter.hasNext()){
			sum += iter.next().getAge();
		}
		avg = sum/map.size();
		System.out.println("\nmap�� ����ִ� ��� ������� ������ ��� : " + avg);
	}
}
