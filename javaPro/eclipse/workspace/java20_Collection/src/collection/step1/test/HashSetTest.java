package collection.step1.test;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Set s = new HashSet<String>();
		
		s.add("�����");
		s.add("������");
		s.add("���Ͽ�");
		s.add("�̿���");
		s.add("�̿���");
		
		// to-do 3
		s.clear();
		System.out.println(s);	
	}
}
