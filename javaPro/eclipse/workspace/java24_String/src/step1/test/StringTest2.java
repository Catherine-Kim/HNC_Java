package step1.test;

import java.util.StringTokenizer;

public class StringTest2 {
	public static void main(String[] args) {
		String str = "�迬��";
		System.out.println("1. [length()] \"�迬��\"�� ���ڿ��� ���� :: " + str.length());
		
		String str2 = str.replace('��', '��');
		System.out.println("\n2. [replace()] \"�迬��\"�� '��'�� '��'���� ���� :: " + str2);
		
		String str3 = str2.substring(1, 3);
		System.out.println("\n3. [substring()] �迬�� �� \"����\"�� ��� :: " + str3);
		
		String str4 = str2.substring(1);
		System.out.println("\n4. [substring()] str2.substring(1) �̷��� �� ���ñ� :: " + str3);
		
		System.out.println("\n5. str�� Ȥ�ó� �ٲ� �� ������ :: " + str);
		
		String s1 = "���ӽ�����";
		String s2 = " ���ӽ� ����";
		String s3 = "���ӽ� ���� ";
		
		System.out.print("\n6. \"���ӽ�����\"�� \" ���ӽ� ����\"�� ���� ���ڿ��ΰ�? :: ");
		if(s1.equals(s2))
			System.out.println("Same Data");
		else
			System.out.println("Different Data");
		
		System.out.print("\n7. [trim()] trim()�� �Ἥ ������ �����ϸ� \"���ӽ�����\"��"
				+ "\" ���ӽ� ����\"�� ���� ���ڿ��ϱ�? :: ");
		if(s1.equals(s2.trim()))
			System.out.println("Same Data");
		else
			System.out.println("Different Data");
		
		System.out.print("\n8. [trim()] trim()�� �Ἥ ������ �����ϸ� \" ���ӽ� ����\"��"
				+ "\"���ӽ� ���� \"�� ���� ���ڿ��ϱ�? :: ");
		if(s2.trim().equals(s3.trim()))
			System.out.println("Same Data");
		else
			System.out.println("Different Data");
		
		System.out.print("\n9. [replace()]��� ������� �����ϰ�  \" ���ӽ� ����\"�� \"���ӽ� ���� \" �� :: ");
		if(s2.replace(" ",  "").equals(s3.replace(" ",  "")))
			System.out.println("Same Data");
		else
			System.out.println("Different Data");
		
		System.out.print("\n10. [indexOf()] \" ���ӽ� ����\" ���� '��'�� index��? :: ");
		System.out.println(s2.indexOf("��"));
		
		System.out.print("\n11. [charAt()] \" ���ӽ� ����\" ���� index 2�� �ش��ϴ� ���ڴ�? :: ");
		System.out.println(s2.charAt(2));
		
		System.out.println("\n12. [split()] \"����, ����, ����, ȣ��, ����, ����, ����\" ���� �̸��� ���� :: ");
		String bts = "����, ����, ����, ȣ��, ����, ����, ����";
		String[] slist = bts.split(", ");
		
		for(int i = 0; i < slist.length; i++)
			System.out.println(slist[i]);
		
		System.out.println("\n13. [StrintTokenizer] \"����, ����, ����, ����, �¿�\" ���� �̸��� ���� :: ");
		String redvelvet = "����, ����, ����, ����, �¿�";
		StringTokenizer token = new StringTokenizer(redvelvet, ", ");
		
		while(token.hasMoreTokens()){
			System.out.println(token.nextToken());
		}
		
		System.out.println("\n13. ���� �� ���� ������� \"����, ����, ����, ����, ����\" ���� �̸��� ���� :: ");
		String wondergirls = "����, ����, ����, ����, ����";
		
		System.out.println("    1) split() ���");
		String[] wlist = wondergirls.split(", ");
		for(int i = 0; i < wlist.length; i++)
			System.out.println("      " + wlist[i]);
		
		System.out.println("\n    2) StringTokenizer Ŭ���� ���");
		StringTokenizer wToken = new StringTokenizer(wondergirls, ", ");
		while(wToken.hasMoreTokens())
			System.out.println("      " + wToken.nextToken());
		
		System.out.println("\n14. [split()] \"�ÿ� �ؼ� ��ȣ   ���� �쿵 ����\" "
				+ "���� ���� ���� ������ �ν��ұ�? :: ");
		String twopm = "�ÿ� �ؼ� ��ȣ   ���� �쿵 ����";
		String[] tlist = twopm.split(" ");
		
		for(String s : tlist){
			System.out.println(s);
		}
		
		System.out.println("\n15. [StringTokenizer] \"�ÿ� �ؼ� ��ȣ   ���� �쿵 ����\" "
				+ "���� ���� ���� ������ �ν��ұ�? :: ");
		StringTokenizer tToken = new StringTokenizer(twopm, " ");
		
		while(tToken.hasMoreTokens())
			System.out.println(tToken.nextToken());
		
		System.out.print("\n16. [startsWith] \"���� ������ �� ��� �ǰ���??\" �� \"��\"�� �����ϴ°�? :: ");
		String start = "���� ������ �� ��� �ǰ���??";
		System.out.println(start.startsWith("��"));
		
		System.out.print("\n17. [startsWith] \"���� ������ �� ��� �ǰ���??\" �� \"����\"�� �����ϴ°�? :: ");
		System.out.println(start.startsWith("����"));
		
		System.out.print("\n18. [endsWith] \"���� ������ �� ��� �ǰ���??\" �� \"��\"�� �����°�? :: ");
		System.out.println(start.endsWith("��"));
		
		System.out.print("\n19. [endsWith] \"���� ������ �� ��� �ǰ���??\" �� \"??\"�� �����°�? :: ");
		System.out.println(start.endsWith("??"));
		
		System.out.print("\n20. [toLowerCase()] \"VANESSA HUDGENS\"�� �ҹ��ڷ� �ٲٱ� :: ");
		String vh = "VANESSA HUDGENS";
		System.out.println(vh.toLowerCase());
		
		System.out.print("\n20. [toUpperCase()] \"vanessa hudgens\"�� �빮�ڷ� �ٲٱ� :: ");
		System.out.println(vh.toLowerCase().toUpperCase());
	}
}
