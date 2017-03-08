package market.util;
/*
 * 상품이 입고되는 날짜에 대한 정보를 담고 있는 VO 클래스
 */
public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate(int year, int month, int day) { // 생성자 생성
		
		this.year = year;
		this.month = month;
		this.day = day;
	}
	// 이하 setter/getter 생성
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
}
