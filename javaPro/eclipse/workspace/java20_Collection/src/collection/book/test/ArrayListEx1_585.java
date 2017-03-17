package collection.book.test;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1_585 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		// list ����
		while(list.size() < 10){
			list.add((int)(Math.random() * 30 + 1));
		}
		
		print(list);
		
		// list�� index 1������ 4�������� list2��� �迭�� ���
		System.out.println("\n1. list�� index 1������ 4�������� list2��� �迭�� ���");
		ArrayList list2 = new ArrayList(list.subList(1, 4));
		print(list, list2);
		
		// list�� list2�� �����Ѵ�
		System.out.println("\n2. list�� list2�� �����Ѵ�");
		Collections.sort(list);
		Collections.sort(list2);
		print(list, list2);
		
		// list�� list2�� ��Ҹ� ��� ������ �ִ��� Ȯ��
		System.out.println("\n3. list�� list2�� ��Ҹ� ��� ������ �ִ��� Ȯ��");
		System.out.println("Does 'list' contain all the elements from 'list2'?");
		System.out.println("> " + list.containsAll(list2));
		
		// list2�� B, C�� �߰�
		System.out.println("\n4. list2�� B, C�� �߰�");
		list2.add('B');
		list2.add('C');
		print(list, list2);
		
		// list2�� 3��° index�� A �߰�
		System.out.println("\n5. list2�� 3��° index�� A �߰�");
		list2.add(3, 'A');
		print(list, list2);
		
		// list2�� 3��° index�� ���� AA�� ����
		System.out.println("\n6. list2�� 3��° index�� ���� AA�� ����");
		list2.set(3, "AA");
		print(list, list2);
		
		// list���� list2�� ��ġ�� �κи� ����� �������� ����
		System.out.println("\n7. list���� list2�� ��ġ�� �κи� ����� �������� ����");
		System.out.println("RetainAll() done?");
		System.out.println("> " + list.retainAll(list2));
		print(list, list2);
		
		// list2���� list�� ���Ե� ��ü���� ����
		System.out.println("\n8.list2���� list�� ���Ե� ��ü���� ����");
		for(int i = list2.size() - 1; i >= 0; i--){
			
			if(list.contains(list2.get(i))){
				list2.remove(i);
			}
		}
		print(list, list2);
	}
	
	static void print(ArrayList alist, ArrayList blist){
		System.out.println("list : " + alist);
		System.out.println("list2 : " + blist);
	}
	
	static void print(ArrayList alist){
		System.out.println("list : " + alist);
	}
}
