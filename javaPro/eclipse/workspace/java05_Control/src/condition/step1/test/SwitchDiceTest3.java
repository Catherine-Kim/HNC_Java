package condition.step1.test;

 //�ֻ��� ������ �������� �غ���

public class SwitchDiceTest3 {
	public static void main(String[] args) {
		int dice = (int)(Math.random()*6+1);
		
		System.out.println(dice);
		
		switch(dice){
		case 1:
		case 3:
		case 5:
			System.out.println("�̰� Ȧ��");
			break;
		case 2:
		case 4:
		case 6:
			System.out.println("�̰� ¦��");
			break;
		default :
			System.out.println("�߸��� ����");
			
		}
	}
}
