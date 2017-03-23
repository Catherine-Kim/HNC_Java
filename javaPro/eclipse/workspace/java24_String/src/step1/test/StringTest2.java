package step1.test;

import java.util.StringTokenizer;

public class StringTest2 {
	public static void main(String[] args) {
		String str = "김연아";
		System.out.println("1. [length()] \"김연아\"의 문자열의 길이 :: " + str.length());
		
		String str2 = str.replace('아', '경');
		System.out.println("\n2. [replace()] \"김연아\"의 '아'를 '경'으로 변경 :: " + str2);
		
		String str3 = str2.substring(1, 3);
		System.out.println("\n3. [substring()] 김연경 중 \"연경\"만 출력 :: " + str3);
		
		String str4 = str2.substring(1);
		System.out.println("\n4. [substring()] str2.substring(1) 이러면 뭐 나올까 :: " + str3);
		
		System.out.println("\n5. str은 혹시나 바뀐 게 있을까 :: " + str);
		
		String s1 = "제임스고슬링";
		String s2 = " 제임스 고슬링";
		String s3 = "제임스 고슬링 ";
		
		System.out.print("\n6. \"제임스고슬링\"과 \" 제임스 고슬링\"는 같은 문자열인가? :: ");
		if(s1.equals(s2))
			System.out.println("Same Data");
		else
			System.out.println("Different Data");
		
		System.out.print("\n7. [trim()] trim()을 써서 공백을 제거하면 \"제임스고슬링\"과"
				+ "\" 제임스 고슬링\"가 같은 문자열일까? :: ");
		if(s1.equals(s2.trim()))
			System.out.println("Same Data");
		else
			System.out.println("Different Data");
		
		System.out.print("\n8. [trim()] trim()을 써서 공백을 제거하면 \" 제임스 고슬링\"와"
				+ "\"제임스 고슬링 \"가 같은 문자열일까? :: ");
		if(s2.trim().equals(s3.trim()))
			System.out.println("Same Data");
		else
			System.out.println("Different Data");
		
		System.out.print("\n9. [replace()]가운데 공백까지 제거하고  \" 제임스 고슬링\"와 \"제임스 고슬링 \" 비교 :: ");
		if(s2.replace(" ",  "").equals(s3.replace(" ",  "")))
			System.out.println("Same Data");
		else
			System.out.println("Different Data");
		
		System.out.print("\n10. [indexOf()] \" 제임스 고슬링\" 에서 '고'의 index는? :: ");
		System.out.println(s2.indexOf("고"));
		
		System.out.print("\n11. [charAt()] \" 제임스 고슬링\" 에서 index 2에 해당하는 글자는? :: ");
		System.out.println(s2.charAt(2));
		
		System.out.println("\n12. [split()] \"정국, 지민, 태형, 호섭, 남준, 윤기, 석진\" 에서 이름만 추출 :: ");
		String bts = "정국, 지민, 태형, 호섭, 남준, 윤기, 석진";
		String[] slist = bts.split(", ");
		
		for(int i = 0; i < slist.length; i++)
			System.out.println(slist[i]);
		
		System.out.println("\n13. [StrintTokenizer] \"슬기, 주현, 수영, 예리, 승완\" 에서 이름만 추출 :: ");
		String redvelvet = "슬기, 주현, 수영, 예리, 승완";
		StringTokenizer token = new StringTokenizer(redvelvet, ", ");
		
		while(token.hasMoreTokens()){
			System.out.println(token.nextToken());
		}
		
		System.out.println("\n13. 위의 두 가지 방법으로 \"예은, 선예, 소희, 선미, 현아\" 에서 이름만 추출 :: ");
		String wondergirls = "예은, 선예, 소희, 선미, 현아";
		
		System.out.println("    1) split() 사용");
		String[] wlist = wondergirls.split(", ");
		for(int i = 0; i < wlist.length; i++)
			System.out.println("      " + wlist[i]);
		
		System.out.println("\n    2) StringTokenizer 클래스 사용");
		StringTokenizer wToken = new StringTokenizer(wondergirls, ", ");
		while(wToken.hasMoreTokens())
			System.out.println("      " + wToken.nextToken());
		
		System.out.println("\n14. [split()] \"택연 준수 준호   닉쿤 우영 찬성\" "
				+ "에서 여러 개의 공백을 인식할까? :: ");
		String twopm = "택연 준수 준호   닉쿤 우영 찬성";
		String[] tlist = twopm.split(" ");
		
		for(String s : tlist){
			System.out.println(s);
		}
		
		System.out.println("\n15. [StringTokenizer] \"택연 준수 준호   닉쿤 우영 찬성\" "
				+ "에서 여러 개의 공백을 인식할까? :: ");
		StringTokenizer tToken = new StringTokenizer(twopm, " ");
		
		while(tToken.hasMoreTokens())
			System.out.println(tToken.nextToken());
		
		System.out.print("\n16. [startsWith] \"오늘 점심은 뭐 드실 건가요??\" 는 \"오\"로 시작하는가? :: ");
		String start = "오늘 점심은 뭐 드실 건가요??";
		System.out.println(start.startsWith("오"));
		
		System.out.print("\n17. [startsWith] \"오늘 점심은 뭐 드실 건가요??\" 는 \"오늘\"로 시작하는가? :: ");
		System.out.println(start.startsWith("오늘"));
		
		System.out.print("\n18. [endsWith] \"오늘 점심은 뭐 드실 건가요??\" 는 \"요\"로 끝나는가? :: ");
		System.out.println(start.endsWith("요"));
		
		System.out.print("\n19. [endsWith] \"오늘 점심은 뭐 드실 건가요??\" 는 \"??\"로 끝나는가? :: ");
		System.out.println(start.endsWith("??"));
		
		System.out.print("\n20. [toLowerCase()] \"VANESSA HUDGENS\"를 소문자로 바꾸기 :: ");
		String vh = "VANESSA HUDGENS";
		System.out.println(vh.toLowerCase());
		
		System.out.print("\n20. [toUpperCase()] \"vanessa hudgens\"를 대문자로 바꾸기 :: ");
		System.out.println(vh.toLowerCase().toUpperCase());
	}
}
