package collection.book.test;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1_585 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		// list 생성
		while(list.size() < 10){
			list.add((int)(Math.random() * 30 + 1));
		}
		
		print(list);
		
		// list의 index 1번부터 4번까지를 list2라는 배열에 담기
		System.out.println("\n1. list의 index 1번부터 4번까지를 list2라는 배열에 담기");
		ArrayList list2 = new ArrayList(list.subList(1, 4));
		print(list, list2);
		
		// list와 list2를 정렬한다
		System.out.println("\n2. list와 list2를 정렬한다");
		Collections.sort(list);
		Collections.sort(list2);
		print(list, list2);
		
		// list가 list2의 요소를 모두 가지고 있는지 확인
		System.out.println("\n3. list가 list2의 요소를 모두 가지고 있는지 확인");
		System.out.println("Does 'list' contain all the elements from 'list2'?");
		System.out.println("> " + list.containsAll(list2));
		
		// list2에 B, C를 추가
		System.out.println("\n4. list2에 B, C를 추가");
		list2.add('B');
		list2.add('C');
		print(list, list2);
		
		// list2의 3번째 index에 A 추가
		System.out.println("\n5. list2의 3번째 index에 A 추가");
		list2.add(3, 'A');
		print(list, list2);
		
		// list2의 3번째 index의 값을 AA로 수정
		System.out.println("\n6. list2의 3번째 index의 값을 AA로 수정");
		list2.set(3, "AA");
		print(list, list2);
		
		// list에서 list2와 겹치는 부분만 남기고 나머지는 삭제
		System.out.println("\n7. list에서 list2와 겹치는 부분만 남기고 나머지는 삭제");
		System.out.println("RetainAll() done?");
		System.out.println("> " + list.retainAll(list2));
		print(list, list2);
		
		// list2에서 list에 포함된 객체들을 삭제
		System.out.println("\n8.list2에서 list에 포함된 객체들을 삭제");
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
