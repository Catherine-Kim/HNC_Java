package file.step1.test;

import java.io.File;
import java.io.IOException;

public class FileMethodTest3 {
	public static void main(String[] args) throws IOException {
		// 1. c:\\kosta\\prob1
		File dir = new File("c:" + File.separator + "kosta" + File.separator + "prob1");
		System.out.println("파일의 경로 :" + dir.getPath()); // 경로로는 나오지만 실제로는 없다
		System.out.println("파일의 경로가 실질적으로 존재합니까? " + dir.exists()); // (boolean)
																	// exists

		// 2.
		File dir2 = new File("c:" + File.separator + "kosta" + File.separator + "prob1");
		System.out.println("디렉토리 생성 : " + dir2.mkdirs()); // (boolean)mkdirs
		System.out.println("파일의 경로가 실질적으로 존재합니까? " + dir.exists());
		System.out.println("dir2는 파일인가요? " + dir2.isFile()); // false
		System.out.println("그럼 디렉토리 인가요? " + dir2.isDirectory()); // true
		System.out.println("절대경로는(경로만)?" + dir2.getAbsolutePath());
		System.out.println("dir2의 상위 디렉토리경로 :" + dir2.getParentFile());

		// 3.
		File file = new File(dir2.getPath() + File.separator + "hello.html");
		System.out.println("파일의 경로 : " + file.getPath());
		System.out.println("파일이 존재합니까?" + file.isFile());

		// 만약에 파일이 없다면 해당 디렉토리 안에 직접 파일을 생성...
		if (!file.isFile()) {
			boolean createFile = file.createNewFile(); // 왜 폭탄터짐?
			System.out.println("이제는 파일이 만들어 졌나요? " + createFile);

		}
	}
}
