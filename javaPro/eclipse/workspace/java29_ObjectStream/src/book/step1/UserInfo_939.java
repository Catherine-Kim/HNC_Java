package book.step1;

import java.io.Serializable;

public class UserInfo_939 implements Serializable{
	private String name;
	private int age;
	private String password;
	
	public UserInfo_939(){
		this("Unknown", 0, "0000");
	}

	public UserInfo_939(String name, int age, String password) {
		this.name = name;
		this.age = age;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return name + "(" + age + ") " + password;
	}
}
