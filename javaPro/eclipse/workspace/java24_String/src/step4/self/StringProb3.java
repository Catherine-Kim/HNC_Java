package step4.self;

public class StringProb3 {
	public static void main(String[] args) {
		System.out.println("<< 첫 번째 메시지 >>");
		handleMessage("PROD-00001:iPhone4:940000:4:애플");
		System.out.println("<< 두 번째 메시지 >>");
		handleMessage("PROD-00002:갤럭시S:960000:삼성");
	}

	private static void handleMessage(String string) {
		String[] productInfo = string.split(":");		// 인자로 받은 String을 ":"을 기준으로 split
		
		if(productInfo.length != 5){		// 제품 정보는 총 5가지가 아니라면 잘못된 형식
			System.out.println("메시지 형식이 잘못되었습니다.");
			System.out.println("메시지는 제품아이디:제품명:가격:수량:제조사 형식이어야 합니다.");
		}else{
			System.out.println("제품 아이디 : " + productInfo[0]);
			System.out.println("제품명 : " + productInfo[1]);
			System.out.println("가격 : " + productInfo[2]);
			System.out.println("수량 : " + productInfo[3]);
			System.out.println("제조사 : " + productInfo[4]);
		}
	}
}
