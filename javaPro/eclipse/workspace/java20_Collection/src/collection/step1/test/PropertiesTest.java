package collection.step1.test;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		Properties p = System.getProperties();
		
		Enumeration e = p.propertyNames();
		
		while(e.hasMoreElements()){
			String name = (String) e.nextElement();
			String value = p.getProperty(name);
			System.out.println(name + "-----------------" + value);
		}
	}
}
