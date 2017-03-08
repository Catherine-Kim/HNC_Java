package data.type.test;

import data.type.Shirt;

/*
 * ShirtAppTest ::
 * ������ ������ Ÿ�Կ� ���� �⺻���� ������ ������ �Ҵ�Ǿ������� ���� �����
 * Ȯ���ϴ� �׽�Ʈ Ŭ����
 */

public class ShirtAppTest {

	public static void main(String[] args) {
		// �޸𸮿� Shirt Ŭ������ �ı����� �ö󰣴�.
		// ������ �ʱ�ȭ
		Shirt s = new Shirt();
		
		System.out.println("Code Number :: " + s.getCodeNo());
		System.out.println("Brand :: " + s.getBrand());
		System.out.println("Long-sleeved :: " + s.isLongSleeved());
		System.out.println("Size :: " + s.getSize());
		System.out.println("Price :: " + s.getPrice());
		
		// ����� �ʱ�ȭ
		s.setShirtInfo("Andersson Bell", 123, true, 110.0f, 'M');
		
		System.out.println("\n------------Initialized------------\n");
		
		System.out.println("Code Number :: " + s.getCodeNo());
		System.out.println("Brand :: " + s.getBrand());
		System.out.println("Long-sleeved :: " + s.isLongSleeved());
		System.out.println("Size :: " + s.getSize());
		System.out.println("Price :: " + s.getPrice());
	}
}

