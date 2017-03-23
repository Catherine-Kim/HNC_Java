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
		
		String stars = "���ٿ� �ں��� �ڹο� ������ ���ٿ� ������ �ڽ���";
		
		StringService service = new StringService();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ã���� �ϴ� file�� Ȯ���ڸ� �Է��ϼ� : ");
		String user_extension = sc.nextLine();
		service.printFileExtension(files, user_extension);
		
		System.out.println("\nstar�� ��� : ");
		HashSet<String> starset = service.getStars(stars);
		Iterator it = starset.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}

class StringService{
	public void printFileExtension(String[] someFiles, String extension){
		// Ư�� Ȯ���ڸ� ���� ���� �̸�'��' ���
		// files�� �޾ƿ�  String[] �߿��� Ȯ���ڰ� Ư���� ������ ������ ������ ã�Ƽ� ���� �̸��� ���
		String[] slist = null;
		boolean found = false;
		
		for(String s : someFiles){
			if(s.endsWith(extension)){
				found = true;
				System.out.println(s.split("."+extension)[0]);
			}
		}
		
		if(found == false)
			System.out.println("�ش� Ȯ���ڸ� ���� ������ �������� �ʽ��ϴ�.");
	}
	
	public HashSet<String> getStars(String stars){
		// stars�� �޾Ƽ� ������ �������� �̸��� ���� ��, �ݺ��Ǵ� �̸����� ������ ������ ������ star�� HashSet�� ��� ����
		HashSet<String> set = new HashSet<String>();
		String[] slist = stars.split(" ");
		
		for(String s : slist){
			if(!set.contains(s))
				set.add(s);
		}		
		return set;
	}
}
