package file.step1.test;

import java.io.File;
import java.io.IOException;

public class FileMethodTest3 {
	public static void main(String[] args) throws IOException {
		// 1. c:\\kosta\\prob1
		File dir = new File("c:" + File.separator + "kosta" + File.separator + "prob1");
		System.out.println("������ ��� :" + dir.getPath()); // ��ηδ� �������� �����δ� ����
		System.out.println("������ ��ΰ� ���������� �����մϱ�? " + dir.exists()); // (boolean)
																	// exists

		// 2.
		File dir2 = new File("c:" + File.separator + "kosta" + File.separator + "prob1");
		System.out.println("���丮 ���� : " + dir2.mkdirs()); // (boolean)mkdirs
		System.out.println("������ ��ΰ� ���������� �����մϱ�? " + dir.exists());
		System.out.println("dir2�� �����ΰ���? " + dir2.isFile()); // false
		System.out.println("�׷� ���丮 �ΰ���? " + dir2.isDirectory()); // true
		System.out.println("�����δ�(��θ�)?" + dir2.getAbsolutePath());
		System.out.println("dir2�� ���� ���丮��� :" + dir2.getParentFile());

		// 3.
		File file = new File(dir2.getPath() + File.separator + "hello.html");
		System.out.println("������ ��� : " + file.getPath());
		System.out.println("������ �����մϱ�?" + file.isFile());

		// ���࿡ ������ ���ٸ� �ش� ���丮 �ȿ� ���� ������ ����...
		if (!file.isFile()) {
			boolean createFile = file.createNewFile(); // �� ��ź����?
			System.out.println("������ ������ ����� ������? " + createFile);

		}
	}
}
