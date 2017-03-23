package io.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInputTest2{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("키보드로 데이터 입력하삼");
		
		String line = null;
		while((line = br.readLine()).equalsIgnoreCase("q")){
			if(line.equalsIgnoreCase("q")){
				System.out.println("입력 종료");
				break;
			}
			System.out.println("읽어들인 데이터 :: " + line);
		}
	}
}
