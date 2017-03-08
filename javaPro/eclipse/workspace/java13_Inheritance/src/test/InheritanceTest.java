package test;

import vo.child.Manager;
import vo.child.Student;
import vo.child.Teacher;
import vo.parent.Person;

public class InheritanceTest {
	public static void main(String[] args){
		Student s1 = new Student("�����", 940610, "���ϵ� ������", 100);
		Student s2 = new Student("�̾���", 940610, "����Ư���� ���α�", 30);
		Student s3 = new Student("������", 940610, "��û���� õ�Ƚ�", 40);
		Student s4 = new Student("������", 940610, "����Ư���� �߱�", 50);
		Student s5 = new Student("�̿���", 940610, "��û�ϵ� û�ֽ�", 45);
		Student s6 = new Student("�ڼ���", 940610, "���ֵ� ��������", 35);
	
		Teacher t1 = new Teacher("������", 920101, "��⵵ ���ν�", "����");
		Teacher t2 = new Teacher("������", 920101, "����Ư���� ������", "����");
	
		Manager m1 = new Manager("������", 950101, "����Ư���� ������", "��ȹ");
		Manager m2 = new Manager("������", 950101, "��󳲵� ���ֽ�", "��ȹ");
	
		Person[] plist = {s1, s2, s3, s4, s5, s6, t1, t2, m1, m2};
		
		System.out.println("----------------------��� �迭 ��� ���� ���----------------------");
		for(Person p : plist){
			System.out.println(p.toString());
		}
		System.out.println("\n");
		
		System.out.println("------------------------��� �л� ���� ���------------------------");
		for(Person p : plist){
			if(p instanceof Student){
				System.out.println(p.toString());
			}
		}
		System.out.println("\n");
		
		System.out.println("-------------------ù ��° ������ ���� �ٲ㼭 ���-------------------");
		for(Person p : plist){
			if(p instanceof Teacher){
				((Teacher) p).changeSubject("�߱���");
				System.out.println(p.toString());
				break;
			}
		}
		System.out.println("\n");
		
		System.out.println("------------------�л��� ������ ��� & ���� ���ϱ�-------------------");
		int sum = 0;
		int avg = 0;
		int count = 0;
		
		for(Person p : plist){
			if(p instanceof Student){
				sum += ((Student) p).getScore();
				count++;
			}
		}
		
		avg = sum/count;
		
		System.out.println("�л����� ������ " + sum + "�̰�, ����� " + avg + "�Դϴ�.");
		System.out.println("\n");
		
		System.out.println("----------------------50�� �Ѵ� �л� �� ���ϱ�----------------------");
		count = 0;
		for(Person p : plist){
			if(p instanceof Student){
				if(((Student) p).getScore() >= 50)
					count++;
			}
		}
		System.out.println("50�� �̻��� �л��� �� " + count + "���Դϴ�.");
	}
	
	
	
}
