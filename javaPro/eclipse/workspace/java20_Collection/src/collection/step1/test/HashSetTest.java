package collection.step1.test;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Set s = new HashSet<String>();
		
		s.add("김우정");
		s.add("이태현");
		s.add("최일웅");
		s.add("이영욱");
		s.add("이영욱");
		
		// to-do 3
		s.clear();
		System.out.println(s);	
	}
}
