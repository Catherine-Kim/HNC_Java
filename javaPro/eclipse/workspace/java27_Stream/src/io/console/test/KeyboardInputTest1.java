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

		System.out.println("Ű����� ������ �Է��ϻ�");
		// �� �� ���� ��µǸ� InputStream�� �� ��������� �ڿ��� ����� �غ� �Ǿ��ٴ� ��

		try {
			line = br.readLine(); // readLine()�� ����ó���� ���־�� ��
			while (line != null) {
				System.out.println("�о���� ������ :: " + line);
				line = br.readLine(); // �� �� �� ������ �޾��ָ� ��� �ݺ�
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
