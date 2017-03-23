package step2.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class StringAdvancedTest {
	public static void main(String[] args) {
		String[] files = {
				"Begin Again.avi",
				"StringTest1.java",
				"August Rush.mp3",
				"Lucy.avi",
				"rt.jar",
				"Inception.mp4",
				"Lalaland.avi",
				"Not Today.mp3"
		};
		
		String stars = "문근영 박보영 박민영 김태희 문근영 김태희 박신혜";
		
		StringService service = new StringService();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("찾고자 하는 file의 확장자를 입력하셈 : ");
		String user_extension = sc.nextLine();
		service.printFileExtension(files, user_extension);
		
		System.out.println("\nstar들 출력 : ");
		HashSet<String> starset = service.getStars(stars);
		Iterator it = starset.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}

class StringService{
	public void printFileExtension(String[] someFiles, String extension){
		// 특정 확장자를 가진 파일 이름'만' 출력
		// files로 받아온  String[] 중에서 확장자가 특정한 것으로 끝나는 파일을 찾아서 파일 이름만 출력
		String[] slist = null;
		boolean found = false;
		
		for(String s : someFiles){
			if(s.endsWith(extension)){
				found = true;
				System.out.println(s.split("."+extension)[0]);
			}
		}
		
		if(found == false)
			System.out.println("해당 확장자를 가진 파일이 존재하지 않습니다.");
	}
	
	public HashSet<String> getStars(String stars){
		// stars를 받아서 공백을 기준으로 이름을 나눈 후, 반복되는 이름들을 제외한 각각의 고유한 star만 HashSet에 담아 리턴
		HashSet<String> set = new HashSet<String>();
		String[] slist = stars.split(" ");
		
		for(String s : slist){
			if(!set.contains(s))
				set.add(s);
		}		
		return set;
	}
}
