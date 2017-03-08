package util;

/*
 * 고용인들의 생년월일에 대한 정보를 담고 있는 날짜 클래스
 * 값이 주입되는 통로로 생성자를 사용
 */

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}	
	
	public String toString(){
		return year + "/" + month + "/" + day + "/";
	}
}
