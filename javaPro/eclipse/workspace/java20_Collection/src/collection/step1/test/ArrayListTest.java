package collection.step1.test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		List<String> slist = new ArrayList<String>();
		// 앞 generics를 썼으면 뒤 generics도 똑같아야 함
		
		slist.add("이태현"); slist.add("전종현"); slist.add("김정식");
		slist.add("전종현"); slist.add("이영욱"); slist.add("명정현");
		
		// to-do 3
		String firstData = slist.get(1);
		System.out.println(firstData);
	
	}
}
