package step4.self;

public class StringProb3 {
	public static void main(String[] args) {
		System.out.println("<< ù ��° �޽��� >>");
		handleMessage("PROD-00001:iPhone4:940000:4:����");
		System.out.println("<< �� ��° �޽��� >>");
		handleMessage("PROD-00002:������S:960000:�Ｚ");
	}

	private static void handleMessage(String string) {
		String[] productInfo = string.split(":");		// ���ڷ� ���� String�� ":"�� �������� split
		
		if(productInfo.length != 5){		// ��ǰ ������ �� 5������ �ƴ϶�� �߸��� ����
			System.out.println("�޽��� ������ �߸��Ǿ����ϴ�.");
			System.out.println("�޽����� ��ǰ���̵�:��ǰ��:����:����:������ �����̾�� �մϴ�.");
		}else{
			System.out.println("��ǰ ���̵� : " + productInfo[0]);
			System.out.println("��ǰ�� : " + productInfo[1]);
			System.out.println("���� : " + productInfo[2]);
			System.out.println("���� : " + productInfo[3]);
			System.out.println("������ : " + productInfo[4]);
		}
	}
}
