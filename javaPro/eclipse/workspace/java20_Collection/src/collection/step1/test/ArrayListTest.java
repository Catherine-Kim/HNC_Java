package collection.step1.test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		List<String> slist = new ArrayList<String>();
		// �� generics�� ������ �� generics�� �Ȱ��ƾ� ��
		
		slist.add("������"); slist.add("������"); slist.add("������");
		slist.add("������"); slist.add("�̿���"); slist.add("������");
		
		// to-do 3
		String firstData = slist.get(1);
		System.out.println(firstData);
	
	}
}
