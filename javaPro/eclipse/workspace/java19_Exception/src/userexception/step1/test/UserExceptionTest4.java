package userexception.step1.test;

import userexception.step1.test.ZeroException;

class Customer4{
	public void add(int i, int j) throws ZeroException{
		if(j == 0){
			System.out.println("1. Created a bomb");
			System.out.println("2. Threw the bomb");
			throw new ZeroException();
		}
		// j를 분모로 하는 로직이 나온다....치자
	}
}

public class UserExceptionTest4 {
	public static void main(String[] args) {
		Customer4 c = new Customer4();
		try{
			c.add(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		}catch(ZeroException e){
			System.out.println(e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Need two arguements..");
		}
	}
}
