package test;

import vo.child.Manager;
import vo.child.Student;
import vo.child.Teacher;
import vo.parent.Person;

public class InheritanceTest {
	public static void main(String[] args){
		Student s1 = new Student("김우정", 940610, "경상북도 울진군", 100);
		Student s2 = new Student("이알찬", 940610, "서울특별시 종로구", 30);
		Student s3 = new Student("서고은", 940610, "충청남도 천안시", 40);
		Student s4 = new Student("고유진", 940610, "서울특별시 중구", 50);
		Student s5 = new Student("이예진", 940610, "충청북도 청주시", 45);
		Student s6 = new Student("박세연", 940610, "제주도 서귀포시", 35);
	
		Teacher t1 = new Teacher("이윤재", 920101, "경기도 용인시", "영어");
		Teacher t2 = new Teacher("최지수", 920101, "서울특별시 마포구", "수학");
	
		Manager m1 = new Manager("이재익", 950101, "서울특별시 강서구", "기획");
		Manager m2 = new Manager("이정수", 950101, "경상남도 진주시", "기획");
	
		Person[] plist = {s1, s2, s3, s4, s5, s6, t1, t2, m1, m2};
		
		System.out.println("----------------------모든 배열 요소 정보 출력----------------------");
		for(Person p : plist){
			System.out.println(p.toString());
		}
		System.out.println("\n");
		
		System.out.println("------------------------모든 학생 정보 출력------------------------");
		for(Person p : plist){
			if(p instanceof Student){
				System.out.println(p.toString());
			}
		}
		System.out.println("\n");
		
		System.out.println("-------------------첫 번째 선생님 과목 바꿔서 출력-------------------");
		for(Person p : plist){
			if(p instanceof Teacher){
				((Teacher) p).changeSubject("중국어");
				System.out.println(p.toString());
				break;
			}
		}
		System.out.println("\n");
		
		System.out.println("------------------학생들 점수의 평균 & 총합 구하기-------------------");
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
		
		System.out.println("학생들의 총합은 " + sum + "이고, 평균은 " + avg + "입니다.");
		System.out.println("\n");
		
		System.out.println("----------------------50점 넘는 학생 수 구하기----------------------");
		count = 0;
		for(Person p : plist){
			if(p instanceof Student){
				if(((Student) p).getScore() >= 50)
					count++;
			}
		}
		System.out.println("50점 이상인 학생은 총 " + count + "명입니다.");
	}
	
	
	
}
