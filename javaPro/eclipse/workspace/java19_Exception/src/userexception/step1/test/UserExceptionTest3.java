package userexception.step1.test;

import userexception.step1.test.ZeroException;

class Customer3{
	public void add(int i, int j) throws ZeroException{
		if(j == 0){
			System.out.println("1. Created a bomb");
			System.out.println("2. Threw the bomb");
			throw new ZeroException();
		}
		// j를 분모로 하는 로직이 나온다....치자
	}
}

public class UserExceptionTest3 {
	public static void main(String[] args) {
		Customer3 c = new Customer3();
		try{
			c.add(10, 0);
		}catch(ZeroException e){
			System.out.println(e.getMessage());
		}
	}
}
