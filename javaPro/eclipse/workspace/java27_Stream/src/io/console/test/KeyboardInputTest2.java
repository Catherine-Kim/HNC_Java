package io.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInputTest2{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ű����� ������ �Է��ϻ�");
		
		String line = null;
		while((line = br.readLine()).equalsIgnoreCase("q")){
			if(line.equalsIgnoreCase("q")){
				System.out.println("�Է� ����");
				break;
			}
			System.out.println("�о���� ������ :: " + line);
		}
	}
}
