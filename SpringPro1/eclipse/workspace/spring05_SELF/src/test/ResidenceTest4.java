package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import self4.Dormitory;
import self4.Hotel;
import self4.House;

public class ResidenceTest4 {
	public static void main(String[] args){
		ApplicationContext factory = new ClassPathXmlApplicationContext("self4.xml");
		Hotel hotel = (Hotel) factory.getBean("hotel");
		Dormitory dorm = (Dormitory) factory.getBean("dorm");
		House house = (House) factory.getBean("house");
		
		hotel.reside();
		dorm.reside();
		house.reside();
	}
}
