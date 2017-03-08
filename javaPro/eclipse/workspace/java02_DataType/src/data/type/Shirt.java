package data.type;

/*
 * Shirt Class ::
 * �ش� Ŭ���������� 8���� �⺻�� ����Ÿ Ÿ�� ���
 * ������ : byte, int(default), short, long -> default value = 0
 * �Ǽ��� : float, double(default) -> default value = 0.0
 * ������ : char -> default value = '\u0000'
 * ���� : boolean -> default value = false
 * ------------------------------------------------------------
 * 8���� �⺻��(Primitive Data Type)�� ������ ��� ������ Ÿ����
 * Class(Reference) Data Type�� ���Ѵ�. -> default value = null
 * 
 * Class(Reference Data Type
 * 1) ����� ���� Ŭ����(User Definition Class)
 * 2) API Ŭ����
 */

public class Shirt {
	// �ʵ� ����
	String brand;
	int codeNo;
	boolean longSleeved;
	float price;
	char size;

	public void setShirtInfo(String brand, int codeNo, 
			boolean longSleeved, float price, char size){
		this.brand = brand;
		this.codeNo = codeNo;
		this.longSleeved = longSleeved;
		this.price = price;
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public int getCodeNo() {
		return codeNo;
	}

	public boolean isLongSleeved() {
		return longSleeved;
	}

	public float getPrice() {
		return price;
	}

	public char getSize() {
		return size;
	}
	
}
