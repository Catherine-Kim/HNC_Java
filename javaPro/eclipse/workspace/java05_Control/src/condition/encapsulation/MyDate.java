package condition.encapsulation;

import java.util.Calendar;
import java.util.GregorianCalendar;



public class MyDate {
	private int month;
	private int day;
	private int year;
	
	public void setDate(int month, int day, int year){
		this.year = year;
		Calendar cal = Calendar.getInstance();
		if(month >= 1 && month <= 12){
			this.month = month;
			cal.set(year, month - 1, day);
			if(day >= 1 && day <= cal.getActualMaximum(cal.DAY_OF_MONTH)){		
				this.day = day;
			}
		}
	}
	
	public int getMonth(){
		return month;
	}
	
	public int getDay(){
		return day;
	}
	
	public int getYear(){
		return year;
	}
}


