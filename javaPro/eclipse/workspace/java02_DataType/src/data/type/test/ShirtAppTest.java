package data.type.test;

import data.type.Shirt;

/*
 * ShirtAppTest ::
 * 각각의 데이터 타입에 대한 기본값과 적절한 값으로 할당되었는지에 대한 결과를
 * 확인하는 테스트 클래스
 */

public class ShirtAppTest {

	public static void main(String[] args) {
		// 메모리에 Shirt 클래스의 식구들이 올라간다.
		// 묵시적 초기화
		Shirt s = new Shirt();
		
		System.out.println("Code Number :: " + s.getCodeNo());
		System.out.println("Brand :: " + s.getBrand());
		System.out.println("Long-sleeved :: " + s.isLongSleeved());
		System.out.println("Size :: " + s.getSize());
		System.out.println("Price :: " + s.getPrice());
		
		// 명시적 초기화
		s.setShirtInfo("Andersson Bell", 123, true, 110.0f, 'M');
		
		System.out.println("\n------------Initialized------------\n");
		
		System.out.println("Code Number :: " + s.getCodeNo());
		System.out.println("Brand :: " + s.getBrand());
		System.out.println("Long-sleeved :: " + s.isLongSleeved());
		System.out.println("Size :: " + s.getSize());
		System.out.println("Price :: " + s.getPrice());
	}
}

