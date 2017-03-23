package io.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInputTest1 {
	public static void main(String[] args) {
		String line = new String();
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);

		System.out.println("ir, br successed");

		System.out.println("키보드로 데이터 입력하삼");
		// 이 두 줄이 출력되면 InputStream이 잘 만들어졌고 자원을 사용할 준비가 되었다는 뜻

		try {
			line = br.readLine(); // readLine()은 예외처리를 해주어야 함
			while (line != null) {
				System.out.println("읽어들인 데이터 :: " + line);
				line = br.readLine(); // 한 번 더 데이터 받아주면 계속 반복
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
