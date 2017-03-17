package collection.step2.test;

import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args){
		TreeSet<String> ts = new TreeSet<String>();	// generics 무시
		
		// to-do 1
		// alphabet
		ts.add("Catherine");
		ts.add("Blair");
		ts.add("Serena");
		ts.add("Paul");
		ts.add("Hazel");
		ts.add("Adrian");
		
		System.out.println(ts);
	
		// 가나다
		ts.add("김우정");
		ts.add("이알찬");
		ts.add("박세연");
		ts.add("서고은");
		ts.add("고유진");
		ts.add("이예진");
									
		System.out.println(ts);
		
		TreeSet<Integer> tss = new TreeSet<Integer>();
		
		// number
		tss.add(new Integer(11));
		tss.add(new Integer(10));
		tss.add(new Integer(53));
		tss.add(new Integer(29));
		
		System.out.println(tss);
		
		// number
		tss.add(3);
		tss.add(4);
		tss.add(80);
		tss.add(4);
		
		System.out.println(tss);
		System.out.println(tss.higher(11));	// higher()
		
	}
}
