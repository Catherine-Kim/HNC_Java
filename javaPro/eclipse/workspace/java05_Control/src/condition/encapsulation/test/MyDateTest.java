package condition.encapsulation.test;

import java.util.Scanner;

import condition.encapsulation.MyDate;

/*
 * 1. Scanner 객체를 이용해서 month, day에 해당하는 날짜를 콘솔창으로 입력받는다.
 * 2. setDate() 메소드를 이용하여 사용자에게 받은 날짜를 주입한다.
 * 3. 최종적으로 날짜를 콘솔로 출력한다. ex) 오늘은 몇 월 며칠 입니다.
 */

public class MyDateTest {
	public static void main(String[] args){
		MyDate md = new MyDate();
		
		Scanner sc = new Scanner(System.in);
		md.setDate(sc.nextInt(), sc.nextInt(), sc.nextInt());
		
		System.out.println("오늘은 " + md.getYear() + "년 " + md.getMonth() + "월 " + md.getDay() + "일이라네");
	}
}
