package collection.step1.test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest2 {
	public static void main(String[] args) {
		List slist = new ArrayList();
		// �� generics�� ������ �� generics�� �Ȱ��ƾ� ��
		
		slist.add("������"); slist.add("������"); slist.add("������");
		slist.add("������"); slist.add("�̿���"); slist.add("������");
		
		// to-do 3
		String firstData = (String)slist.get(1);
		System.out.println(firstData);
	
	}
}
