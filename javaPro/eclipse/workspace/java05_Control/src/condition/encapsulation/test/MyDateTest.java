package condition.encapsulation.test;

import java.util.Scanner;

import condition.encapsulation.MyDate;

/*
 * 1. Scanner ��ü�� �̿��ؼ� month, day�� �ش��ϴ� ��¥�� �ܼ�â���� �Է¹޴´�.
 * 2. setDate() �޼ҵ带 �̿��Ͽ� ����ڿ��� ���� ��¥�� �����Ѵ�.
 * 3. ���������� ��¥�� �ַܼ� ����Ѵ�. ex) ������ �� �� ��ĥ �Դϴ�.
 */

public class MyDateTest {
	public static void main(String[] args){
		MyDate md = new MyDate();
		
		Scanner sc = new Scanner(System.in);
		md.setDate(sc.nextInt(), sc.nextInt(), sc.nextInt());
		
		System.out.println("������ " + md.getYear() + "�� " + md.getMonth() + "�� " + md.getDay() + "���̶��");
	}
}
