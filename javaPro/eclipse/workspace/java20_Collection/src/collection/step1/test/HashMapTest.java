package collection.step1.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import java.util.Iterator;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		// HashMap<Key, Value>
				
		map.put("À¯½Â¹Î", 70);
		map.put("À¯½Ã¹Î", 96);
		map.put("È²±³¾È", 60);
		map.put("ÀÌÀç¸í", 90);
		map.put("È«ÁØÇ¥", 88);
		map.put("¹Ú±ÙÇý", 60);
				
		System.out.println("keySet() ::");
		
		// to-do 2 teacher ver.
		Set<String> set2 = map.keySet();
		System.out.println(set2);
		
		Collection<Integer> scores = map.values();
		System.out.println(scores);
		
		// to-do 3
		Iterator ii = scores.iterator();
		int temp = 0;
		int avg = 0;
		int sum = 0;
		while(ii.hasNext()){
			temp = (int)ii.next();
			sum += temp;
		}
		avg = sum/scores.size();
		
		System.out.println("Sum : " + sum + ", Average : " + avg);
		
		// to-do 4
		System.out.println("The highest score : " + Collections.max(scores));
	}
}
