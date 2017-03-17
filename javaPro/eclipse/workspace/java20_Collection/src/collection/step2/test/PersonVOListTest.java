package collection.step2.test;

import java.util.List;
import collection.step2.vo.PersonVO;
import java.util.ArrayList;

public class PersonVOListTest {
	public static void main(String[] args) {
		// to-do 1
		List<PersonVO> list = new ArrayList<PersonVO>();
		
		list.add(new PersonVO("�����", 24, "���ϵ� ������"));
		list.add(new PersonVO("Ȳ�ϴ�", 27, "��⵵ ���ν�"));
		list.add(new PersonVO("������", 26, "����Ư���� ������"));
		list.add(new PersonVO("����ȯ", 28, "���ֵ� ��������"));
		list.add(new PersonVO("�ڿ���", 31, "���ϵ� ������"));
		
		// list�� �߰��� ����� ��
		System.out.println("list�� �߰��� ����� �� : " + list.size());
		
		// list�� ù ��°�� ����� ���
		System.out.println("\nù ��°�� ����� ��� : " + list.get(0));
		
		// ��� ������� ���� �� ��
		int sum = 0;
		for(PersonVO pv : list){
			sum += pv.getAge();
		}
		System.out.println("\n��� ������� ���� �� �� : " + sum);
		
		// ��� ���� ��� �� ���
		int avg = sum/list.size();
		System.out.println("\n��� ������� ���� ��� : " + avg);
		
		// "���ϵ� ���������� ��� ��� �� & ���� ���
		int num = 0;
		System.out.println("\n���ϵ� �������� ��� ��� : ");
		for(PersonVO pv : list){
			if(pv.getAddress().equals("���ϵ� ������")){
				num++;
				System.out.println(pv);
			}
		}
		System.out.println("\n���ϵ� �������� ��� ��� �� : " + num);
	}
}
