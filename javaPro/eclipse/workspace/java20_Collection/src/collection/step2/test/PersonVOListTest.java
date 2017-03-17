package collection.step2.test;

import java.util.List;
import collection.step2.vo.PersonVO;
import java.util.ArrayList;

public class PersonVOListTest {
	public static void main(String[] args) {
		// to-do 1
		List<PersonVO> list = new ArrayList<PersonVO>();
		
		list.add(new PersonVO("김우정", 24, "경상북도 울진군"));
		list.add(new PersonVO("황하늬", 27, "경기도 용인시"));
		list.add(new PersonVO("정윤묵", 26, "서울특별시 마포구"));
		list.add(new PersonVO("임재환", 28, "제주도 서귀포시"));
		list.add(new PersonVO("박용희", 31, "경상북도 울진군"));
		
		// list에 추가된 사람의 수
		System.out.println("list에 추가된 사람의 수 : " + list.size());
		
		// list에 첫 번째로 저장된 사람
		System.out.println("\n첫 번째에 저장된 사람 : " + list.get(0));
		
		// 모든 사람들의 나이 총 합
		int sum = 0;
		for(PersonVO pv : list){
			sum += pv.getAge();
		}
		System.out.println("\n모든 사람들의 나이 총 합 : " + sum);
		
		// 평균 연령 계산 후 출력
		int avg = sum/list.size();
		System.out.println("\n모든 사람들의 나이 평균 : " + avg);
		
		// "경상북도 울진군”에 사는 사람 수 & 정보 출력
		int num = 0;
		System.out.println("\n경상북도 울진군에 사는 사람 : ");
		for(PersonVO pv : list){
			if(pv.getAddress().equals("경상북도 울진군")){
				num++;
				System.out.println(pv);
			}
		}
		System.out.println("\n경상북도 울진군에 사는 사람 수 : " + num);
	}
}
